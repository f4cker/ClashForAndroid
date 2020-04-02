package com.github.kr328.clash.service.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "profile_select_proxies",
    foreignKeys = [ForeignKey(
        entity = ClashProfileEntity::class,
        childColumns = ["profile_id"],
        parentColumns = ["id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )],
    primaryKeys = ["profile_id", "proxy"]
)
data class ClashProfileProxyEntity(
    @ColumnInfo(name = "profile_id") val profileId: Long,
    @ColumnInfo(name = "proxy") val proxy: String,
    @ColumnInfo(name = "selected") val selected: String
)