package tw.com.rayalala.www.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tw.com.rayalala.www.Utils;

/**
 * 首頁
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Controller
@RequestMapping("/")
public class IndexController {

//	@Autowired
//	BannerRepository bannerRepository;
	@Autowired
	private ServletContext servletContext;

//	@RequestMapping(path = "/banner.json", produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	String banner() throws IOException {
//		JSONArray jsonArray = new JSONArray();
//
//		for (Banner banner : bannerRepository.findAll()) {
//			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Taipei"), Locale.TAIWAN);
//			calendar.setTime(banner.getUploaded());
//			String bannerId = banner.getId().toString().concat(Long.toString(calendar.getTimeInMillis()));
//			bannerId = Skein512Small.hash(bannerId);
//
//			Map<String, String> mapOfDesktop = new HashMap<>();
//			mapOfDesktop.put("name", "P");
//			mapOfDesktop.put("src", Utils.PREFIX_FOR_DESKTOP.concat(Skein512Small.hash(bannerId)).concat(".jpg"));
//
//			Map<String, String> mapOfMobile = new HashMap<>();
//			mapOfMobile.put("name", "M");
//			mapOfMobile.put("src", Utils.PREFIX_FOR_MOBILE.concat(Skein512Small.hash(bannerId)).concat(".jpg"));
//
//			Map<String, String> mapOfTablet = new HashMap<>();
//			mapOfTablet.put("name", "T");
//			mapOfTablet.put("src", Utils.PREFIX_FOR_TABLET.concat(Skein512Small.hash(bannerId)).concat(".jpg"));
//
//			List<Map<String, String>> list = new ArrayList<>();
//			list.add(mapOfDesktop);
//			list.add(mapOfMobile);
//			list.add(mapOfTablet);
//
//			HashMap<String, Object> hashMap = new HashMap();
//			hashMap.put("banner_id", Skein512Small.hash(bannerId));
//			hashMap.put("banner_name", banner.getName());
//			hashMap.put("imgData", list);
//			hashMap.put("md5", Utils.md5(bannerId));
//			try {
//				hashMap.put("blowfish", Utils.blowfish(bannerId));
//				hashMap.put("blowfishRandom", Utils.blowfish(bannerId, true));
//			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException exception) {
//				Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, exception);
//			}
//
//			jsonArray.put(hashMap);
//		}
//
//		System.out.println(servletContext.getRealPath("/bannerForPC"));
//		return jsonArray.toString();
//	}
	@GetMapping(path = "/", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	String index() {
		return Utils.md5("banner");
	}

	@PostMapping("/upload.asp")
	@SuppressWarnings("null")
	ModelAndView upload(@RequestPart("file") MultipartFile multipartFile, @CookieValue(defaultValue = "[]", name = "shoppingCart") String cookieValue) throws Exception {
		String child = Utils.blowfish(multipartFile.getOriginalFilename(), true), extension = null;
		switch (multipartFile.getContentType()) {
			case "image/jpg":
			case "image/jpeg":
				extension = ".jpg";
				break;
			case "image/png":
				extension = ".png";
				break;
			default:
				extension = "";
		}
		File file = new File(System.getProperty("java.io.tmpdir"), child);
		multipartFile.transferTo(file);

		InputStream inputStream = getClass().getResourceAsStream("/awsCredentials.properties");
		AWSCredentials awsCredentials = new PropertiesCredentials(inputStream);
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1).build();
		PutObjectRequest putObjectRequest = new PutObjectRequest("12df53fea8b3adfa6c2ec456dd22e204", child.concat(extension), file);
		putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		amazonS3.putObject(putObjectRequest);
		IOUtils.closeQuietly(inputStream);

		file.delete();

		return new ModelAndView("redirect:/xyz.htm");
	}

	@PostMapping("/upload.aspx")
	ModelAndView upload(@RequestPart("file") MultipartFile multipartFile) {
		String child = Utils.md5(Utils.getTimeInMillis().toString()).concat(".jpg");
		File fileForDesktop = new File(servletContext.getRealPath(Utils.PREFIX_FOR_DESKTOP), child),
			fileForMobile = new File(servletContext.getRealPath(Utils.PREFIX_FOR_MOBILE), child),
			fileForTablet = new File(servletContext.getRealPath(Utils.PREFIX_FOR_TABLET), child);

		System.out.println(new File(servletContext.getRealPath(Utils.PREFIX_FOR_DESKTOP)).canWrite());
		System.out.println(fileForDesktop.getAbsolutePath());
		System.out.println(multipartFile.getContentType());

		try {
			fileForDesktop.setWritable(true);
			multipartFile.transferTo(fileForDesktop);
		} catch (IOException | IllegalStateException exception) {
			Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, exception);
			return new ModelAndView("redirect:/abc.htm");
		}

		return new ModelAndView("redirect:/xyz.htm");
	}
}
