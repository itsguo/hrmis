package com.brainstrongtech.hrmis.dao;

import java.util.List;

import com.brainstrongtech.hrmis.domain.User;

public interface LoginDao {
      List<User> checkUser();
}
