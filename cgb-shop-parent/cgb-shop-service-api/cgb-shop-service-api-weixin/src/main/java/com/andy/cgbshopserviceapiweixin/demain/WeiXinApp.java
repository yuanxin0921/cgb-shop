package com.andy.cgbshopserviceapiweixin.demain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain =true)
@ToString
public class WeiXinApp {
    private String name;
    private int age;
}
