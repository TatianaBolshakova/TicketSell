package com.example.ticketselling.app

import android.app.Application
import com.example.ticketselling.di.appModule
import com.example.ticketselling.di.dataModule
import com.example.ticketselling.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG )
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}