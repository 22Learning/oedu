package com.oedu.login.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserInterface {

    Map<String,String> getNameByIds(List<String> userIds);
}
