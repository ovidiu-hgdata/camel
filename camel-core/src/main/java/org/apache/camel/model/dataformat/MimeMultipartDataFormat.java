/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model.dataformat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.CamelContext;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spi.Metadata;

/**
 * MIME Multipart data format
 */
@Metadata(label = "dataformat,transformation", title = "MIME Multipart")
@XmlRootElement(name = "mime-multipart")
@XmlAccessorType(XmlAccessType.FIELD)
public class MimeMultipartDataFormat extends DataFormatDefinition {

    @XmlAttribute
    @Metadata(defaultValue = "mixed")
    private String multipartSubType = "mixed";
    @XmlAttribute
    @Metadata(defaultValue = "false")
    private Boolean multipartWithoutAttachment;
    @XmlAttribute
    @Metadata(defaultValue = "false")
    private Boolean headersInline;
    @XmlAttribute
    @Metadata(defaultValue = "false")
    private Boolean binaryContent;

    public MimeMultipartDataFormat() {
        super("mime-multipart");
    }

    @Override
    protected void configureDataFormat(DataFormat dataFormat, CamelContext camelContext) {
        if (getMultipartSubType() != null) {
            setProperty(camelContext, dataFormat, "multipartSubType", getMultipartSubType());
        }
        if (getMultipartWithoutAttachment() != null) {
            setProperty(camelContext, dataFormat, "multipartWithoutAttachment", getMultipartWithoutAttachment());
        }
        if (getHeadersInline() != null) {
            setProperty(camelContext, dataFormat, "headersInline", getHeadersInline());
        }
        if (getBinaryContent() != null) {
            setProperty(camelContext, dataFormat, "binaryContent", getBinaryContent());
        }
    }

    public String getMultipartSubType() {
        return multipartSubType;
    }

    /**
     * Specify the subtype of the MIME Multipart.
     * <p>
     * Default is "mixed".
     */
    public void setMultipartSubType(String multipartSubType) {
        this.multipartSubType = multipartSubType;
    }

    public Boolean getMultipartWithoutAttachment() {
        return multipartWithoutAttachment;
    }

    /**
     * Defines whether a message without attachment is also marshaled into a
     * MIME Multipart (with only one body part).
     * <p>
     * Default is "false".
     */
    public void setMultipartWithoutAttachment(Boolean multipartWithoutAttachment) {
        this.multipartWithoutAttachment = multipartWithoutAttachment;
    }

    public Boolean getHeadersInline() {
        return headersInline;
    }

    /**
     * Defines whether the MIME-Multipart headers are part of the message body
     * (true) or are set as Camel headers (false).
     * <p>
     * Default is "false".
     */
    public void setHeadersInline(Boolean headersInline) {
        this.headersInline = headersInline;
    }

    public Boolean getBinaryContent() {
        return binaryContent;
    }

    /**
     * Defines whether the content of binary parts in the MIME multipart is
     * binary (true) or Base-64 encoded (false)
     * <p>
     * Default is "false".
     */
    public void setBinaryContent(Boolean binaryContent) {
        this.binaryContent = binaryContent;
    }
}
