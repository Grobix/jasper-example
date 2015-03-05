package com.rgerdes.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ContactBean {

    private String firstName;
    private String lastName;
    private List<AddressBean> addresses;
    private List<PhoneBean> phones;
}
