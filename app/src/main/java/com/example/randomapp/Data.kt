package com.example.randomapp

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Random
import kotlin.math.roundToInt

class Data {
    private val gendersList =
        ("Agender,Androgynous,Bigender,Binary gender,Binary sex,Cisgender,Cis man,Cis woman,Cissexism,Cross-dressing,Deadnaming,Drag king,Drag queen,FTM,Gender dysphoria,Gender euphoria,Gender expression,Gender fluid,Gender identity,Gender affirming healthcare,Gender roles and expectations,Genderqueer,Intersex,LGBTQIA+,Misgender/mispronoun,MTF,Nonbinary,Transgender,Trans,Transitioning,Transphobia,Transsexual,Trans feminine,Trans masculine").split(
            ","
        ).toTypedArray()

    private val countriesList =
        "Abkhazia,Afghanistan,Åland Islands,Albania,Algeria,American Samoa,Andorra,Angola,Anguilla,Antarctica,Antigua & Barbuda,Argentina,Armenia,Artsakh,Aruba,Australia,Austria,Azerbaijan,Bahamas,Bahrain,Bangladesh,Barbados,Belarus,Belgium,Belize,Benin,Bermuda,Bhutan,Bolivia,Bosnia & Herzegovina,Botswana,Bouvet Island,Brazil,British Indian Ocean Territory,British Virgin Islands,Brunei,Bulgaria,Burkina Faso,Burundi,Cambodia,Cameroon,Canada,Cape Verde,Caribbean Netherlands,Cayman Islands,Central African Republic,Chad,Chile,China,Christmas Island,Cocos,Colombia,Comoros,Congo,Cook Islands,Costa Rica,Croatia,Cuba,Curaçao,Cyprus,Czechia,Côte d’Ivoire,Denmark,Djibouti,Dominica,Dominican Republic,Ecuador,Egypt,El Salvador,Equatorial Guinea,Eritrea,Estonia,Eswatini,Ethiopia,Falkland Islands,Faroe Islands,Fiji,Finland,France,French Guiana,French Polynesia,French Southern Territories,Gabon,Gambia,Georgia,Germany,Ghana,Gibraltar,Greece,Greenland,Grenada,Guadeloupe,Guam,Guatemala,Guernsey,Guinea,Guinea-Bissau,Guyana,Haiti,Heard & McDonald Islands,Honduras,Hong Kong SAR China,Hungary,Iceland,India,Indonesia,Iran,Iraq,Ireland,Isle of Man,Israel,Italy,Jamaica,Japan,Jersey,Jordan,Kazakhstan,Kenya,Kiribati,Kosovo,Kuwait,Kyrgyzstan,Laos,Latvia,Lebanon,Lesotho,Liberia,Libya,Liechtenstein,Lithuania,Luxembourg,Macao SAR China,Madagascar,Malawi,Malaysia,Maldives,Mali,Malta,Marshall Islands,Martinique,Mauritania,Mauritius,Mayotte,Mexico,Micronesia,Moldova,Monaco,Mongolia,Montenegro,Montserrat,Morocco,Mozambique,Myanmar,Namibia,Nauru,Nepal,Netherlands,New Caledonia,New Zealand,Nicaragua,Niger,Nigeria,Niue,Norfolk Island,North Korea,North Macedonia,Northern Cyprus,Northern Mariana Islands,Norway,Oman,Pakistan,Palau,Palestinian Territories,Panama,Papua New Guinea,Paraguay,Peru,Philippines,Pitcairn Islands,Poland,Portugal,Puerto Rico,Qatar,Romania,Russia,Rwanda,Réunion,Sahrawi Arab Democratic Republic,Samoa,San Marino,Saudi Arabia,Senegal,Serbia,Seychelles,Sierra Leone,Singapore,Sint Maarten,Slovakia,Slovenia,Solomon Islands,Somalia,Somaliland,South Africa,South Georgia & South Sandwich Islands,South Korea,South Ossetia,South Sudan,Spain,Sri Lanka,St. Barthélemy,St. Helena,St. Kitts & Nevis,St. Lucia,St. Martin,St. Pierre & Miquelon,St. Vincent & Grenadines,Sudan,Suriname,Svalbard & Jan Mayen,Sweden,Switzerland,Syria,São Tomé & Príncipe,Taiwan,Tajikistan,Tanzania,Thailand,Timor-Leste,Togo,Tokelau,Tonga,Transnistria,Trinidad & Tobago,Tunisia,Turkey,Turkmenistan,Turks & Caicos Islands,Tuvalu,U.S. Outlying Islands,U.S. Virgin Islands,Uganda,Ukraine,United Arab Emirates,United Kingdom,United States,Uruguay,Uzbekistan,Vanuatu,Vatican City,Venezuela,Vietnam,Wallis & Futuna,Western Sahara,Yemen,Zambia".split(
            ","
        ).toTypedArray()

    var allList = arrayOf(
        "Random Number... loading",
        "Random Name... loading",
        "Random Color... loading",
        "Random Street... loading",
        "Random Coordinates... loading",
        "Random ID... loading",
        "Random Phone... loading",
        "Random Country... loading",
        "Random City... loading",
        "Random Time... loading",
        "Random Animal... loading",
        "Random Food... loading",
        "Random Date... loading",
        "Random Email Address... loading",
        "Random Website... loading",
        "Random Age... loading",
        "Random Gender... loading",
        "Random Height... loading",
        "Random Weight... loading",
        "Random Blood Type... loading",
        "Random Job... loading",
        "Random Car Model... loading",
        "Random Company... loading",
        "Random Credit Card Number... loading",
        "Random Credit Card CVV... loading",
        "Random Mac Address... loading",
        "Random IPv4 Address... loading",
        "Random IPv6 Address... loading",
        "Random Color Hex... loading",
        "Random Color RGB... loading",
        "Random Password... loading",
    )
    var listOfImages: Array<Int> = arrayOf(
        R.drawable.number_48px,
        R.drawable.rename_24,
        R.drawable.color_lens_24,
        R.drawable.home_24,
        R.drawable.coordinates_24,
        R.drawable.identity_24,
        R.drawable.phone_24,
        R.drawable.flag_24,
        R.drawable.location_city_24,
        R.drawable.time_24,
        R.drawable.pets_24,
        R.drawable.fastfood_24,
        R.drawable.date_24,
        R.drawable.email_24,
        R.drawable.web_24,
        R.drawable.elderly_woman_24,
        R.drawable.gender_24,
        R.drawable.height_24,
        R.drawable.monitor_weight_24,
        R.drawable.bloodtype_24,
        R.drawable.work_24,
        R.drawable.car_24,
        R.drawable.storefront_24,
        R.drawable.credit_card_24,
        R.drawable.password_24,
        R.drawable.developer_board_24,
        R.drawable.format_h4_48px,
        R.drawable.format_h6_48px,
        R.drawable.format_color_text_48px,
        R.drawable.format_paint_48px,
        R.drawable.lock_48px
    )
    private val bloodTypes = arrayOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")


    fun getRandomIPv4Address(): String {
        return (1..4).map { (0..255).random() }.joinToString(".")
    }

    fun getRandomIPv6Address(): String {
        // List of A - z
        val alphabet = ('A'..'Z') + ('a'..'z')

        var address = ""

        for (i in 1..16) {
            val randomLetter = alphabet.random()
            val randomNum = (0..9).random()

            val randomLetterOrNumber = (1..10).random()

            if (randomLetterOrNumber % 2 == 0) address += randomLetter
            else address += randomNum
        }

        // : every 4 characters
        return address.chunked(4).joinToString(":")
    }

    fun getRandomGender(): String {
        return gendersList.random()
    }

    fun getRandomFrom(file: Int, context: Context): String {
        val inputStream = context.resources.openRawResource(file)
        val bufferReader = BufferedReader(InputStreamReader(inputStream))

        var allLines = ""
        var eachLine = bufferReader.readLine()

        // Run until last line
        var i = 0
        while (eachLine != "end" && i < 1000) {
            eachLine = bufferReader.readLine()

            if (eachLine == null) continue

            allLines += eachLine + "\n"
            i++
        }

        val splitted = allLines.split("\n").toTypedArray()
        val randomPosition = Random().nextInt(splitted.size)
        return splitted[randomPosition]
    }

    fun getRandomColorHex(): String {
        val ran = Random()
        var color = "#"

        while (color.length < 6) {
            color += Integer.toHexString(ran.nextInt())
        }

        return color
    }

    fun getRandomColorRGB(): String {
        val randomRed = (0..255).random()
        val randomGreen = (0..255).random()
        val randomBlue = (0..255).random()

        return "$randomRed, $randomGreen, $randomBlue"
    }

    fun getRandomCoordianets(): String {
        // Choose a random coordinate with 4 digits after the decimal point
        var randomLatitude = (0..90).random() + (0..9999).random() / 10000.0
        var randomLongitude = (0..180).random() + (0..9999).random() / 10000.0

        // Round 4 digits after the decimal point
        randomLatitude = (randomLatitude * 10000.0).roundToInt() / 10000.0
        randomLongitude = (randomLongitude * 10000.0).roundToInt() / 10000.0


        return "$randomLatitude, $randomLongitude"
    }

    fun getRandomId(): String {
        // Generate 9 random numbers and call it ID :>
        return (1..9).map { (0..9).random() }.joinToString("")
    }

    fun getRandomPhone(): String {
        // Generate phone number
        val num = (1..10).map { (0..9).random() }.joinToString("")

        // - every 3 digits
        return num.chunked(3).joinToString("-")
    }

    fun getRandomDate(): String {
        // Generate random date
        val randomYear = (1900..2020).random()
        val randomMonth = (1..12).random()
        val randomDay = (1..28).random()

        return "$randomYear-$randomMonth-$randomDay"
    }

    fun getRandomTime(): String {
        // Generate random time
        val randomHour = (0..23).random()
        val randomMinute = (0..59).random()
        val randomSecond = (0..59).random()

        return "$randomHour:$randomMinute:$randomSecond"
    }

    fun getRandomCountry(): String {
        return countriesList.random()
    }

    fun getRandomBloodType(): String {
        return bloodTypes[Random().nextInt(bloodTypes.size)]
    }

    fun getRandomAge(): Int {
        // Fun fact: The oldest person in the world was 122 years and 164 days old :>
        return Random().nextInt(122) + 1
    }

    fun getRandomHeight(): String {
        // Generate random height
        val randomHeight = (1..250).random()
        return "$randomHeight cm (${(randomHeight * 0.3).roundToInt()} inches)"
    }

    fun getRandomWeight(): String {
        // Fun fact: The heaviest person in the world was 635 kg (1400 lbs) :>
        // Generate random weight
        val randomWeight = (1..635).random()
        return "$randomWeight kg (${(randomWeight * 2.2).roundToInt()} lbs)"
    }

    fun getRandomCreditCardNumber(): String {
        // Generate random credit card number
        val num = (1..16).map { (0..9).random() }.joinToString("")

        // Insert - every 4 digits
        return num.substring(0, 4) + "-" + num.substring(4, 8) + "-" + num.substring(
            8, 12
        ) + "-" + num.substring(12, 16)
    }

    fun getRandomCreditCardCVV(): String {
        // Generate random credit card CVV
        return (1..3).map { (0..9).random() }.joinToString("")
    }

    fun getRandomMacAddress(): String {
        // Alphabet
        val alphabet = ('A'..'Z') + ('a'..'z')
        var mac = ""

        for (i in 1..12) {
            val randomLetter = alphabet.random()
            val randomNum = (0..9).random()

            val randomLetterOrNumber = (1..10).random()

            if (randomLetterOrNumber % 2 == 0) mac += randomLetter
            else mac += randomNum
        }

        // Insert : every 2 digits
        return mac.chunked(2).joinToString(":")
    }

    fun getRandomPassword(): String {
        // Generate random password from letters and numbers with loop
        val alphabet = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        var password = ""

        for (i in 1..10) {
            password += alphabet[Random().nextInt(alphabet.size)]
        }

        return password
    }
}