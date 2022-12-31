package com.darma1budi.skyobject

object PlanetsData {
    private val planetNames = arrayOf(
        "Matahari",
        "Merkurius",
        "Venus",
        "Bumi",
        "Mars",
        "Jupiter",
        "Saturnus",
        "Uranus",
        "Neptunus",
        "Pluto"
    )

    private val planetDescriptions = arrayOf(
        "Matahari atau Surya adalah bintang di pusat tata surya. Bentuknya nyaris bulat dan terdiri dari plasma panas bercampur medan magnet. Diameternya sekitar 1.392.684 km, kira-kira 109 kali diameter Bumi, dan massanya mewakili kurang lebih 99,86 % massa total tata surya.",
        "Merkurius adalah planet terkecil di Tata Surya sekaligus yang terdekat dari Matahari. Periode revolusi planet ini merupakan yang terpendek dari semua planet di Tata Surya, yakni 87,79 hari.",
        "Venus adalah planet terdekat kedua dari Matahari setelah Merkurius. Planet ini mengorbit Matahari selama 224,7 hari Bumi. Venus tidak memiliki satelit alami dan dinamai dari dewi cinta dan kecantikan dalam mitologi Romawi.",
        "Bumi adalah planet ketiga dari Matahari yang merupakan planet terpadat dan terbesar kelima dari delapan planet dalam Tata Surya. Bumi juga merupakan planet terbesar dari empat planet kebumian di Tata Surya. Bumi terkadang disebut dengan dunia atau Planet Biru.",
        "Mars adalah planet terdekat keempat dari Matahari. Namanya diambil dari dewa perang Romawi, Mars. Planet ini sering dijuluki sebagai \"planet merah\" karena tampak dari jauh berwarna kemerah-kemerahan. Ini disebabkan oleh keberadaan besi(III) oksida di permukaan planet Mars.",
        "Jupiter atau Yupiter adalah planet terdekat kelima dari Matahari setelah Merkurius, Venus, Bumi, dan Mars. Planet ini juga merupakan planet terbesar di Tata Surya. Jupiter merupakan raksasa gas dengan massa seperseribu massa Matahari dan dua setengah kali jumlah massa semua planet lain di Tata Surya.",
        "Saturnus adalah planet keenam dari Matahari dan merupakan planet terbesar kedua di Tata Surya setelah Jupiter. Saturnus juga merupakan sebuah raksasa gas yang memiliki radius rata-rata sekitar 9 kali radius rata-rata Bumi.",
        "Uranus adalah planet ketujuh dari Matahari. Uranus merupakan planet yang memiliki jari-jari terbesar ketiga sekaligus massa terbesar keempat di Tata Surya. Uranus juga merupakan satu-satunya planet yang namanya berasal dari tokoh dalam mitologi Yunani, dari versi Latinisasi nama dewa langit Yunani Ouranos.",
        "Neptunus merupakan planet terjauh jika ditinjau dari Matahari. Planet ini dinamai dari dewa lautan Romawi. Neptunus merupakan planet terbesar keempat berdasarkan diameter dan terbesar ketiga berdasarkan massa. Massa Neptunus tercatat 17 kali lebih besar daripada Bumi, dan sedikit lebih kecil daripada Uranus.",
        "Pluto adalah planet katai di sabuk Kuiper dan objek trans-Neptunus pertama yang ditemukan. Pluto merupakan planet katai terbesar dan bermassa terbesar kedua di Tata Surya dan benda terbesar kesembilan dan bermassa terbesar kesepuluh yang mengorbit Matahari secara langsung."
    )

    private val planetPictures = intArrayOf(
        R.drawable.matahari,
        R.drawable.merkurius,
        R.drawable.venus,
        R.drawable.bumi,
        R.drawable.mars,
        R.drawable.jupiter,
        R.drawable.saturnus,
        R.drawable.uranus,
        R.drawable.neptunus,
        R.drawable.pluto
    )

    private val planetVideo = intArrayOf(
        R.raw.matahari,
        R.raw.merkurius,
        R.raw.venus,
        R.raw.bumi,
        R.raw.mars,
        R.raw.jupiter,
        R.raw.saturnus,
        R.raw.uranus,
        R.raw.neptunus,
        R.raw.pluto
    )

    private val planetRadius = doubleArrayOf(
        696340.0,
        2439.7,
        6051.8,
        6371.0,
        3389.5,
        69911.0,
        58232.0,
        25362.0,
        24622.0,
        1188.3
    )

    private val planetMasses = doubleArrayOf(
        1.989E30,
        3.285E23,
        4.867E24,
        5.972E24,
        6.39E23,
        1.898E27,
        5.683E26,
        8.681E25,
        1.024E26,
        1.305E22
    )

    private val planetAreas = doubleArrayOf(
        6.09E12,
        7.48E7,
        4.602E8,
        5.101E8,
        1.448E8,
        6.142E10,
        4.27E10,
        8.083E9,
        7.618E9,
        1.665E7,
    )

    private val planetGravities = doubleArrayOf(
        274.0,
        3.7,
        8.87,
        9.807,
        3.721,
        24.79,
        10.44,
        8.87,
        11.15,
        0.62,
    )

    private val planetDistances = doubleArrayOf(
        0.0,
        58.0,
        108.2,
        149.6,
        227.9,
        778.5,
        1434.0,
        2871.0,
        4495.0,
        5900.0
    )

    private val planetRotations = arrayOf(
        "27 hari",
        "58 hari 15 jam 30 menit",
        "116 hari 18 jam",
        "23 jam 56 menit",
        "1 hari 0 jam 37 menit",
        "9 jam 56 menit",
        "10 jam 34 menit",
        "17 jam 14 menit",
        "16 jam 6 menit",
        "6,39 hari",
    )

    private val planetMoons = arrayOf(
        "3122 Florence",
        "Tidak Memiliki Bulan",
        "Tidak Memiliki Bulan",
        "Bulan",
        "Fobos, Deimos",
        "Europa, Io, Ganimede, Kalisto, Amalthea, Adrastea,dan Lainnya",
        "Titan, Enceladus, Mimas, Dione, Iapetus, Tethys, Hyperion, dan Lainnya",
        "Miranda, Titania, Oberon, Ariel, Umbriel, Puck, Cressida, dan Lainnya",
        "Triton, Thalassa, Hippocamp, Nereid, Galatea, dan Lainnya",
        "Kharon, Nix, Styx, Kerberos, Hydra",
    )

    val listData: ArrayList<Planet>
        get() {
            val list = arrayListOf<Planet>()
            for (position in planetNames.indices) {
                val planet = Planet()
                planet.name = planetNames[position]
                planet.description = planetDescriptions[position]
                planet.picture = planetPictures[position]
                planet.video = planetVideo[position]
                planet.averageRadius = planetRadius[position]
                planet.mass = planetMasses[position]
                planet.surfaceArea = planetAreas[position]
                planet.gravity = planetGravities[position]
                planet.distanceFromSun = planetDistances[position]
                planet.rotationTime = planetRotations[position]
                planet.moon = planetMoons[position]
                list.add(planet)
            }
            return list
        }
}