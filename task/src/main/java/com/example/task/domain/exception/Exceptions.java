package com.example.task.domain.exception;

public enum Exceptions {
    OK,
    //GetFullPartyByGLN
    INVALID_GLN, //done
    GLN_DONT_EXIST, //done

    //SearchPartiesByModifiedTime and SearchSimpleTradeitemsByModifiedTime3
//    INVALID_FROMDATE,
//    INVALID_TODATE,
    INVALID_DATE,
//    INVALID_RECORD_COUNT,
//    INVALID_START_RECORD,
    INVALID_RECORD,
    NO_RESULT //done

}
