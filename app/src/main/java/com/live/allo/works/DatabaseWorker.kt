package com.live.allo.works

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.live.allo.database.AppDatabase

class DatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            AppDatabase.getInstance(applicationContext)
            Result.success()
        } catch (ex: Exception) {
            Result.failure()
        }
    }
}

