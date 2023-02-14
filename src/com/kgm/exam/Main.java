package com.kgm.exam.board;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    String queryString1 = "id=33&count=1&age=14&studentNo=65&name=Paul";
    Map<String, String> params1 = Util.getParams(queryString1);
    System.out.println(params1);

    String queryString2 = "id=33&name=Paul&a=[1=2]";
    Map<String, String> params2 = Util.getParams(queryString2);
    System.out.println(params2);

    String queryString3 = "id=33&name=Paul";
    Map<String, String> params3 = Util.getParams(queryString3);
    System.out.println(params3);

    // 압축해제 시작
//    String[] queryStringBits1 = queryString1.split("&");
//
//    for (String bit : queryStringBits1) {
//      String[] bitBits = bit.split("=");
//      params1.put(bitBits[0], bitBits[1]);  // key, value
//    }
//    // 압축해제 끝
  }
}

class Util {
  static Map<String, String> getParams(String queryStr) {
    Map<String, String> params = new HashMap<>();

    String[] queryStrBits = queryStr.split("&");
    for (String bit : queryStrBits) {
      String[] bits = bit.split("=", 2);

      if (bits.length == 1) {
        continue;
      }

      params.put(bits[0], bits[1]);
    }

    return params;
  }
}