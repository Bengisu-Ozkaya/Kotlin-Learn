package com.example.kotlinlearning

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity: android.app.Activity() {
    lateinit var textView : TextView
    lateinit var nameText : EditText
    lateinit var ageText : EditText
    lateinit var jobText : EditText
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // konsola yazdırma
        println("hello")
        println(5)

        // değişkenler
        var x = 5; //variable
        val s = "bengi" // value  // Constant (bir değer verildikten sonra o değer değiştirilemez)
        val a = 12;
        val result = a/2*5
        println(result)
        //println(a/2*5) üstteki ile aynı sonuç

        val myInteger : Int
        myInteger = 10 //Initialize (ilk değer ataması)
        println(myInteger)

        val pi = 3.14 // double
        val myFloat = 3.14f // float

        val metin = "bu metni okuyan kişi şuanda bu metni okuyor..."
        val metin2 : String = "bengi" // val tanımlarken direkt olarak tip ataması da yapılabiliyor

        val name = "bengi"
        val surname = "özkaya"
        val fullName = name + " " + surname
        println(fullName)

        println(name.capitalize()) // baş harf büyütüyo

        var bool : Boolean = true;
        println(3 < 5) //true döner
        println(18 > 19) // false döner

        // Conversion (Birbirlerine dönüştürme)
        var input = "10"
        //println(input * 4) // hata verir çünkü bu bir string
        var inputInt = input.toInt()
        println(inputInt * 4)

        //Array
        val myArray = arrayOf("bengi","gülso","dilo","elif")
        // myArray[3] = myArray.get(3)
        println(myArray[2])
        val numerArray = doubleArrayOf(1.0,2.7,4.0,3.7) // sadece double değerlerden oluşan arrayf
        val mixedArray = arrayOf("bengi",3.48,31) // karışık değerli array

        //ArrayList
        val musicList = arrayListOf<String>("biliyorsun", "sen evlisin")
        musicList.add("ara beni lütfen")
        println(musicList[2])
        musicList.add(2,"baş harfi ben") // belirli indekse eleman ekleme
        println(musicList[2])

        val mixedList = arrayListOf<Any>()
        mixedList.add("abc")
        mixedList.add(7)
        mixedList.add(1.2)
        println("${mixedList[0]}, ${mixedList[1]}, ${mixedList[2]}")

        val exmList = arrayOf(1,2,3,4,5)
        println("first: ${exmList[0]}") // ${} = stringte orayı kod bloğu olarak düşünüyor

        // Set -- tekrara eden elemanları pek de sallamıyor
        val mySet = setOf<Int>(10,11,12,13,14,12) // burada 12 nin tekrar etmesi setin umrunda değil
        println(mySet.size) // 5 döner
        mySet.forEach { println(it) } //dizideki tüm elemanları yazdırır (tekrarlananları 1 kez yazıdırır)

        val nameSet = HashSet<String>()
        nameSet.add("bengi")
        nameSet.add("dilo")
        nameSet.add("elo")
        nameSet.add("gülso")

        // Map - HashMap
        val fruitCalorieMap = hashMapOf<String,Int>()
        fruitCalorieMap.put("apple",53)
        fruitCalorieMap.put("banana",82)
        println(fruitCalorieMap["apple"])

        /* Üstteki mantığın daha ilkel hali
        val fruitArray = arrayOf("apple","banana")
        val calorieArray = arrayOf(53,82)
        println("${fruitArray[0]} : ${calorieArray[0]}")*/

        val myMap = hashMapOf<String,Int>("a" to 1, "b" to 2,"c" to 3)
        println(myMap["b"])


        // if
        val number = 21
        if (number < 10){
            println("<10")
        }else if(number == 10){
            println("=10")
        }else{
            println(">10")
        }

        // switch - when
        val day = 3
        var dayString = "";
        when(day){
            1 -> dayString = "monday"
            2 -> dayString = "tuesday"
            3 -> dayString = "wendesday"
            4 -> dayString = "thursday"
            5 -> dayString = "friday"
            6 -> dayString = "saturday"
            7 -> dayString = "sunday"
            else -> dayString = "günsüz"
        }
        println(dayString)

        //For
        val numberArray  = arrayOf(1,2,3,4,5)

        for (number in numberArray){
            val z = number + 2
            println(z)
        }

        /*üstteki ile tamamen aynı*/
        /*for (i in numberArray.indices){
            val qz = numberArray[i] + 2
            println(qz)
        }*/
        numberArray.forEach { println(it) }

        /* Üstteki ile aynı*/
        /*for (s in numberArray){
            println(s)
        }*/

        //While
        var i = 0;
        while (i < 10){
            println(i)
            i++
        }

        //Function
        test()
        sum(3,15)


        // XML ile birleştirme
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        viewSum(3,8)

        // onClick ile aynı
        /*button.setOnClickListener {
            textView.text = "clicked"
        }*/

        //Class
        val homer = Simpson("Homer Simpson",50,"Nuclear")

        // Nullable - değerin null olabileceği
        var txt : String? = null
        txt = "test"
        println(txt)

        var myNo : Int? = null
        println(myNo?.minus(10)) //yandaki soruişareti null sa çökme null de diyo
        if (myNo!= null){
            println(myNo.minus(2))
        }
        else{
            println("myNo is null")
        }

        //elvis operator
        println(myNo?.minus(5) ?: -10) // null dönerse -10 yazdır

        myNo?.let { println(it*10) } // myNo!= null ile aynı kontrol


        nameText = findViewById<EditText>(R.id.nameText)
        ageText = findViewById<EditText>(R.id.ageText)
        jobText = findViewById<EditText>(R.id.jobText)
    }

    fun test(){
        println("test funct")
    }

    fun sum(a:Int, b:Int) : Int{
        val result = a + b
        return result
    }

    fun viewSum(a:Int, b:Int){
        val result = a + b
        textView.text = "Result: ${result}"
        println(result)
    }

    fun click (view : View){
        val name = nameText.text.toString()
        val age = ageText.text.toString().toIntOrNull()
        val job = jobText.text.toString()

        if(age != null){
            textView.text = "Name: ${name}, Age: ${age}, Job: ${job}"
        }else{
            textView.text = "Enter your age!"
        }
    }
}