package com.example.randomapp

import android.animation.Animator
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import kotlin.concurrent.thread
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    var allList = Data().allList
    private val listOfImages = Data().listOfImages

    // Animation object is not null because it is initialized in onCreate
    private var animationObject: Animation? = null
    private var lotitie: LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewRandom)
        lotitie = findViewById(R.id.lottieAnimation)

        // Always show some dice in the beginning
        lotitie?.progress = 0.2F

        // Load animation object and set it to the animation view
        animationObject = AnimationUtils.loadAnimation(this, R.anim.dice_anim)
        lotitie?.startAnimation(animationObject)


        lotitie?.playAnimation()

        // Click listener
        lotitie?.setOnClickListener {
            // Reset data
            resetData()
            makeDataReady()

            lotitie?.playAnimation()
        }
        // Animation listener
        lotitie?.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                lotitie?.animation = null
            }

            override fun onAnimationEnd(animation: Animator?) {
                lotitie?.progress = 0.2F

                lotitie?.animation = animationObject
                lotitie?.startAnimation(animationObject)
            }

            override fun onAnimationCancel(animation: Animator?) {
                // Do nothing
            }

            override fun onAnimationRepeat(animation: Animator?) {
                // Do nothing
            }
        })

        // Prepare data
        makeDataReady()

        // Set the adapter
        val randomAdapter = RecyclerAdapter(allList, listOfImages)
        val linearLayoutManager = LinearLayoutManager(this)

        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.adapter = randomAdapter
    }

    fun makeDataReady() {
        thread(start = true) {
            thread(start = true) {
                allList[0] = "Number: " + Random().nextInt(1000000)
                allList[1] = "Name: " + Data().getRandomFrom(
                    R.raw.first_names, this
                ) + " " + Data().getRandomFrom(R.raw.last_names, this).lowercase()
                    .replaceFirstChar { it.uppercase() }
                allList[2] = "Color: " + Data().getRandomFrom(R.raw.colors_list, this)
                allList[3] = "Street: " + Data().getRandomFrom(R.raw.street_names, this)
                allList[4] = "Coordinates: " + Data().getRandomCoordianets()
                allList[5] = "ID: " + Data().getRandomId()
            }

            thread(start = true) {
                allList[6] = "Phone: " + Data().getRandomPhone()
                allList[7] = "Country: " + Data().getRandomCountry()
                allList[8] = "City: " + Data().getRandomFrom(R.raw.cities_list, this)
                allList[9] = "Time: " + Data().getRandomTime()
                allList[10] = "Animal: " + Data().getRandomFrom(R.raw.animals, this)
                allList[11] = "Food: " + Data().getRandomFrom(R.raw.dishes, this)
                allList[12] = "Date: " + Data().getRandomDate()
                allList[13] = "Email: " + Data().getRandomFrom(
                    R.raw.first_names, this
                ) + "@" + Data().getRandomFrom(R.raw.domains, this)
            }
            thread(start = true) {
                allList[14] = "Website: www." + Data().getRandomFrom(R.raw.domains, this)
                allList[15] = "Age: " + Data().getRandomAge()
                allList[16] = "Gender: " + Data().getRandomGender()
                allList[17] = "Height: " + Data().getRandomHeight()
                allList[18] = "Weight: " + Data().getRandomWeight()
                allList[19] = "Blood Type: " + Data().getRandomBloodType()
                allList[20] = "Job: " + Data().getRandomFrom(R.raw.jobs, this)
                allList[21] = "Car Model: " + Data().getRandomFrom(R.raw.car_brands, this)
                allList[22] = "Company: " + Data().getRandomFrom(R.raw.fortune_500, this)
            }
            thread(start = true) {
                allList[23] = "Credit Card Number: " + Data().getRandomCreditCardNumber()
                allList[24] = "Credit Card CVV: " + Data().getRandomCreditCardCVV()
                allList[25] = "Mac Address: " + Data().getRandomMacAddress()
                allList[26] = "IPv4 Address: " + Data().getRandomIPv4Address()
                allList[27] = "IPv6 Address: " + Data().getRandomIPv6Address()
                allList[28] = "Color Hex: " + Data().getRandomColorHex()
                allList[29] = "Color RGB: " + Data().getRandomColorRGB()
                allList[30] = "(Strong and ) Random Password: " + Data().getRandomPassword()
            }

            // Update the UI
            runOnUiThread {
                recyclerView?.adapter?.notifyDataSetChanged() // Too lazy to change each one with animation
            }
        }
    }

    private fun resetData() {
        allList = Data().allList
        recyclerView?.adapter = RecyclerAdapter(allList, listOfImages)
    }
}
