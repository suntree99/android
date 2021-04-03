package id.kotlin.belajar

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BelajarApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@BelajarApp)}
    }
}