package tw.com.rayalala.www.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 橫幅
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Entity
@Table(catalog = "\"rayalala\"", schema = "\"public\"", name = "\"Banner\"")
public class Banner implements java.io.Serializable {

	private static final long serialVersionUID = -7984184665918448131L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"", nullable = false)
	@Basic(optional = false)
	private Short id;

	@Column(name = "\"name\"")
	private String name;

	@Basic(optional = false)
	@Column(name = "\"enabled\"", nullable = false)
	@NotNull
	private boolean enabled;

	@Basic(optional = false)
	@Column(name = "\"uploaded\"", nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploaded;

	/**
	 * 預設建構子
	 */
	public Banner() {
	}

	protected Banner(Short id) {
		this.id = id;
	}

	/**
	 * 建構子
	 *
	 * @param name 名稱
	 * @param enabled 啟用
	 * @param uploaded 上傳時戳
	 */
	public Banner(String name, boolean enabled, Date uploaded) {
		this.name = name;
		this.enabled = enabled;
		this.uploaded = uploaded;
	}

	/**
	 * 建構子
	 *
	 * @param enabled 啟用
	 * @param uploaded 上傳時戳
	 */
	Banner(boolean enabled, Date uploaded) {
		this.enabled = enabled;
		this.uploaded = uploaded;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Banner)) {
			return false;
		}
		Banner other = (Banner) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "tw.com.rayalala.www.entity.Banner[ id=" + id + " ]";
	}

	/**
	 * @return 主鍵
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id 主鍵
	 */
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * @return 名稱
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 名稱
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 啟用
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled 啟用
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return 上傳時戳
	 */
	public Date getUploaded() {
		return uploaded;
	}

	/**
	 * @param uploaded 上傳時戳
	 */
	public void setUploaded(Date uploaded) {
		this.uploaded = uploaded;
	}
}
