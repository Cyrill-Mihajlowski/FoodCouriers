package com.foodcouriers.ui.onboard

sealed class OnboardingState {
    object FirstSlide : OnboardingState()
    object SecondSlide : OnboardingState()
    object Auth : OnboardingState()
}