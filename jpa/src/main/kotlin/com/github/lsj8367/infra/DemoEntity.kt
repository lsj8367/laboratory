package com.github.lsj8367.infra

import jakarta.persistence.*

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("code"))])
class DemoEntity(
    var name: String,
    var code: String
) {

    @Id
    @GeneratedValue
    var id: Long? = null

}