package buu.informatics.s59161081.changmoney.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteTable")
data class Favorite(

    @PrimaryKey(autoGenerate = true) var favoriteId : Long = 0L,
    @ColumnInfo(name = "favoriteShortness")var favoriteShortness: String?,
    @ColumnInfo(name = "favoriteName") var favoriteName: String?,
    @ColumnInfo(name = "favoriteNum")var favoriteNum: Int = -1) {
}