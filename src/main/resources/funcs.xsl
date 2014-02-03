<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:javademo="java:biz.c24.io.examples.fpml.XSLTDemo"
                version="2.0">
                
<xsl:template name="fromto">
        <xsl:param name="from" as="xs:string"/>
        <xsl:param name="to" as="xs:string"/>
        <xsl:value-of select="concat('From: ', javademo:lookup($from) , ' to ' , javademo:lookup($to))"/>
</xsl:template>

</xsl:stylesheet>