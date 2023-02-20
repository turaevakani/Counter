package com.geektech.counter

class Presenter {

    private val model = Injector.getModel()
    private lateinit var counterView: CounterView

    fun increment(){
        model.increment()
        counterView.showNewCount(model.count)
        equatingNumbers()
    }

    fun decrement(){
        model.decrement()
        counterView.showNewCount(model.count)
        equatingNumbers()
    }

    fun fillCounterView(counterView: CounterView){
        this.counterView = counterView
    }

    fun equatingNumbers(){
        if (model.count == 10){
            counterView.showToast()
        }

        if (model.count == 15){
            counterView.setGreenColor()
        }
        else{
            counterView.setGreyColor()
        }
    }
}