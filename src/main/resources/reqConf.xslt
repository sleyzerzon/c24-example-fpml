<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:conf="http://www.fpml.org/FpML-5/confirmation"
                version="2.0">
                
<!-- Import shared functions -->
<xsl:import href="funcs.xsl" />

<xsl:output method="xml" indent="yes"/>



<xsl:template match="conf:requestConfirmation">
    <req>
        <xsl:apply-templates/>
    </req>
</xsl:template>

<xsl:template match="conf:header">
    <envelope>
	    <xsl:call-template name="fromto">
	        <xsl:with-param name="from" select="conf:sentBy"/>
	        <xsl:with-param name="to" select="conf:sendTo"/>
	    </xsl:call-template>
	</envelope>
    
    <id><xsl:value-of select="conf:messageId"/></id>
</xsl:template>

<xsl:template match="text()|@*"/>

</xsl:stylesheet>