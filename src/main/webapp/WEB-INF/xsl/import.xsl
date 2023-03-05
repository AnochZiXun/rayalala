<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:output
		method="html"
		encoding="UTF-8"
		omit-xml-declaration="yes"
		indent="no"
		media-type="text/html"
	/>

	<!--標頭之 meta-->
	<xsl:template name="meta">
		<META charset="UTF-8"/>
		<META content="width=device-width, initial-scale=1.0" name="viewport"/>
		<META content="924360823817-nr6d6llapvse0odj392t6kotsshpvuj1.apps.googleusercontent.com" name="google-signin-client_id"/>
		<!--<META content="profile email" name="google-signin-scope"/>-->
	</xsl:template>

	<!--標頭之 link-->
	<xsl:template name="stylesheet">
		<LINK href="https://ajax.googleapis.com/ajax/libs/jqueryui/{@jQueryUIVersion}/themes/dark-hive/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
		<LINK crossorigin="anonymous" href="https://maxcdn.bootstrapcdn.com/bootstrap/{@bootstrapVersion}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<LINK crossorigin="anonymous" href="https://maxcdn.bootstrapcdn.com/bootstrap/{@bootstrapVersion}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
	</xsl:template>

	<!--標頭之 script-->
	<xsl:template name="script">
		<SCRIPT src="https://ajax.googleapis.com/ajax/libs/jquery/{@jQueryVersion}/jquery.min.js"/>
		<SCRIPT src="https://ajax.googleapis.com/ajax/libs/jqueryui/{@jQueryUIVersion}/jquery-ui.min.js"/>
		<SCRIPT src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/jquery-ui-i18n.min.js"/>
		<!--<SCRIPT src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.4.5/jquery-ui-timepicker-addon.min.js"/>-->
		<!--<SCRIPT src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.4.5/i18n/jquery-ui-timepicker-addon-i18n.min.js"/>-->
		<SCRIPT crossorigin="anonymous" src="https://maxcdn.bootstrapcdn.com/bootstrap/{@bootstrapVersion}/js/bootstrap.min.js"/>
		<SCRIPT src="https://use.fontawesome.com/808c65a1ef.js"/>
		<SCRIPT src="https://apis.google.com/js/platform.js?onload=onLoad" async="" defer=""/>
	</xsl:template>

	<!--下拉式選單群組-->
	<xsl:template match="optgroup">
		<OPTGROUP label="{@label}">
			<xsl:apply-templates/>
		</OPTGROUP>
	</xsl:template>

	<!--下拉式選單選項-->
	<xsl:template match="option">
		<OPTION value="{@value}">
			<xsl:if test="@selected">
				<xsl:attribute name="selected"/>
			</xsl:if>
			<xsl:value-of select="." disable-output-escaping="yes"/>
		</OPTION>
	</xsl:template>

</xsl:stylesheet>