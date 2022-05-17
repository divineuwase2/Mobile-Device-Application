package com.app.quiz.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.app.quiz.dao.QuizDao
import com.app.quiz.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors


@Database(
    entities = [Question::class],
    version = 1,
    exportSchema = true )
abstract  class QuizDatabase : RoomDatabase(){
    private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
    abstract fun getQuizDao() : QuizDao
    companion object {
        @Volatile private var instance : QuizDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context, scope: CoroutineScope) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context, scope).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context,scope: CoroutineScope) = Room.databaseBuilder(
            context.applicationContext,
            QuizDatabase::class.java,
            "QuizDatabase"
        ).addCallback(object :RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                scope.launch {
                    instance?.let {
                        it.getQuizDao().addQuestions(
                            Question("1. Who Developed Kotlin?.", "IBM","GOOGLE","JetBrains",  "Microsoft", 2, 1),
                            Question("2. Which extension is responsible to save Kotlin files?", ".kot",".android", ".src", ".kt or .kts", 3, 1),
                            Question("3. How to do a multi-line comment in Kotlin language?", "//", "/***/", "/**/", "None of the above", 2, 1),
                            Question("4. The two types of constructors in Kotlin are:", "Primary and Secondary", "First and the second", "Constant and Parameterized ", "None of these",0, 1),
                            Question("5. What handles null exceptions in kotlin?", "Sealed classes", "Lambda functions", "The Kotlin extension", "Elvis Operator", 3, 1),
                            Question("6. What is the function to print a line in Kotlin?", "PrintLine()", "println()", "print()", "b and c", 3, 1),
                            Question("7. What is the correct function to get the length of a string in Kotlin?", "str.length", "string(length)", "lengthOf(str)", "None of the above", 0, 1),
                            Question("8. Under which license Kotlin was developed?", "1.1","1.5", "2.0", "2.1",2,1 ),
                            Question("9. What is the default visibility in Kotlin", "sealed", "public", "protected", "private", 1, 1),
                            Question("10. What is the default behavior of classes in Kotlin?", "All classes are protected", "All classes are sealed", "All classes are final", "All classes are public", 2, 1),
                            Question("11. Functions in Kotlin can be divided in how many types?", "5", "4", "3", "2",3, 1),
                            Question("12. Which are the basic data types in Kotlin?", "Arrays and Boolean", "Characters", "Strings and Numbers", "All the above", 3, 1),
                            Question("13. Which of these features are available in kotlin but not in the Java language?", "Operator overloading", "Coroutines and Null safety", "Range expression", "All the above", 3, 1),
                            Question("14. Kotlin is really better than Java?", "No, Java is better", "Both have similar functionalities", "Yes, Kotlin is better", "They are the same",  2, 1),
                            Question("15. Can a val value be changed in Kotlin?", "It can be changed but only once", "It can be changed", "val cannot be changed after it is assigned", "None of the above", 2, 1)
                        )
                    }

                }


            }
        }).build()
    }


}