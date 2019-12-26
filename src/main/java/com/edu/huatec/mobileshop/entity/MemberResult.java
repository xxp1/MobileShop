package com.edu.huatec.mobileshop.entity;

import java.util.List;

/**
 * Created by 86182 on 2019/12/12.
 */
public class MemberResult {

    private String msg;
    private int status;
    private MemberEntity data;

    public class MemberEntity{

        private int id;
        private String address;
        private String member;
        private List<String> iphone;
    }
}
