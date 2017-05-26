package com.javacodegeeks.examples.jersey;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBody {
    @XmlElement String hello;
    @XmlElement String foo;
    @XmlElement Integer count;
}