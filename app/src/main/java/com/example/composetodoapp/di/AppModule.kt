package com.example.composetodoapp.di

import android.app.Application
import androidx.room.Room
import com.example.composetodoapp.data.TaskDataBase
import com.example.composetodoapp.data.TaskRepository
import com.example.composetodoapp.data.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesTaskDataBase(app: Application) : TaskDataBase {
        return Room.databaseBuilder(
            app,
            TaskDataBase::class.java,
            "task_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db : TaskDataBase) : TaskRepository {
        return TaskRepositoryImpl(db.dao)
    }
}