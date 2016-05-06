package com.sys

class User {
    String username
    String passwordHash
    String salt          // 原始密码加上该字段 再加密 为存入数据库的密码

    static hasMany = [ roles: Role, permissions: String ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
}
