package com.vukoye.screentimer.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jakewharton.threetenabp.AndroidThreeTen
import com.vukoye.screentimer.R
import com.vukoye.screentimer.ScreenTimerApplication
import com.vukoye.screentimer.di.ApplicationViewModelProvider
import com.vukoye.screentimer.screenactions.ScreenActionsService
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, ApplicationViewModelProvider(this.application as ScreenTimerApplication)).get(ScreenEventListViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidThreeTen.init(this)
        startService(Intent(applicationContext, ScreenActionsService::class.java))
        val adapter = ScreeIntervalAdapter(this, object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Timber.d("click")
            }
        })
        screenEventsList.adapter = adapter
        viewModel.screenIntervals.observe(this, Observer(adapter::setItems))
    }
}
