<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:output
		method="html"
		encoding="UTF-8"
		omit-xml-declaration="yes"
		indent="yes"
		media-type="text/html"
	/>

	<xsl:import href="/import.xsl"/>

	<xsl:template match="/">
		<xsl:text disable-output-escaping="yes">&#60;!DOCTYPE HTML&#62;</xsl:text>
		<HTML dir="ltr" lang="zh-TW">
			<xsl:apply-templates/>
		</HTML>
	</xsl:template>

	<xsl:template match="document">
		<HEAD>
			<xsl:call-template name="meta"/>
			<xsl:call-template name="stylesheet"/>
			<LINK href="/STYLE/common.css" rel="stylesheet" type="text/css"/>
			<xsl:call-template name="script"/>
			<SCRIPT src="/index.js"/>
			<TITLE>網軍</TITLE>
		</HEAD>
		<xsl:comment>
			<xsl:value-of select="system-property('xsl:version')"/>
		</xsl:comment>
		<BODY>
			<NAV class="navbar navbar-fixed-top navbar-inverse">
				<DIV class="container-fluid">
					<DIV class="navbar-header">
						<A class="navbar-brand" href="/">網軍</A>
					</DIV>
					<!--已登入-->
					<xsl:if test="me">
						<UL class="nav navbar-nav">
							<LI class="dropdown">
								<A class="dropdown-toggle" href="javascript:void(0);" data-toggle="dropdown">活動<SPAN class="caret"></SPAN></A>
								<UL class="dropdown-menu">
									<LI>
										<A href="#">已結束的活動</A>
									</LI>
									<!--以下為管理員功能-->
									<LI role="separator" class="divider"/>
									<LI>
										<A class="administrator" href="#">新增活動</A>
									</LI>
									<!--以上為管理員功能-->
								</UL>
							</LI>
							<LI class="dropdown">
								<A class="dropdown-toggle" href="javascript:void(0);" data-toggle="dropdown">點數<SPAN class="caret"></SPAN></A>
								<UL class="dropdown-menu">
									<LI>
										<A href="#">點數歷程</A>
									</LI>
									<LI>
										<A href="#">提領點數</A>
									</LI>
									<!--以下為管理員功能-->
									<LI role="separator" class="divider"/>
									<LI>
										<A class="administrator" href="#">撥款申請</A>
									</LI>
									<!--以上為管理員功能-->
								</UL>
							</LI>
							<!--此為管理員功能-->
							<LI>
								<A class="dropdown-toggle" href="javascript:void(0);" data-toggle="dropdown">會員<SPAN class="caret"></SPAN></A>
								<UL class="dropdown-menu">
									<LI>
										<A href="#">瀏覽與管理</A>
									</LI>
									<!--以下為管理員功能-->
									<LI role="separator" class="divider"/>
									<LI>
										<A class="administrator" href="#">新增會員</A>
									</LI>
									<!--以上為管理員功能-->
								</UL>
							</LI>
						</UL>
					</xsl:if>
					<xsl:choose>
						<!--已登入-->
						<xsl:when test="me">
							<UL class="nav navbar-nav navbar-right">
								<LI class="dropdown">
									<A class="dropdown-toggle" href="javascript:void(0);" data-toggle="dropdown">
										<xsl:value-of select="."/>
										<SPAN class="caret"></SPAN>
									</A>
									<UL class="dropdown-menu">
										<LI>
											<A href="/profile.asp">帳號設定</A>
										</LI>
										<LI>
											<A href="/password.asp">更改密碼</A>
										</LI>
										<LI role="separator" class="divider"/>
										<LI>
											<A href="javascript:signOut();location.reload();">登出</A>
										</LI>
									</UL>
								</LI>
							</UL>
						</xsl:when>
						<!--<未登入-->
						<xsl:otherwise>
							<DIV class="navbar-header navbar-right">
								<DIV class="g-signin2" data-onsuccess="signIn" data-height="50"/>
							</DIV>
						</xsl:otherwise>
					</xsl:choose>
				</DIV>
			</NAV>
			<DIV class="container-fluid">
				<P>A</P>
				<P>b</P>
				<P>c</P>
				<P>d</P>
				<P>e</P>
				<P>f</P>
				<P>g</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>
					<INPUT name="when" readonly="" type="date"/>
				</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
				<P>XYZ</P>
			</DIV>
		</BODY>
	</xsl:template>

</xsl:stylesheet>