package com.tgsbesar.myapplication.UnitTest;

import com.tgsbesar.myapplication.database.User;

public interface LoginCallback {
    void onSuccess(boolean value);
    void onError();
}

