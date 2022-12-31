# GO Lang

## Installation
- Download dan install GO compiler di https://go.dev/
- Cek status instalasi di cmd : `go version`

Pengaturan GOPATH dan GOROOT
- Buka Environment Variables
- Pada User Variables, buat GOPATH mengacu pada alamat workspace
- Pada System Variables, buat GOROOT mengacu pada alamat instalasi
- Cek go environment di cmd : `go env`
- Matikan daluhu Go Module (jika belum digunakan) : `go env -w GO111MODULE="off"`

## Basic Command
Untuk melakukan build atau compile code gunakan perintah dibawah ini
```go
go build namaFile.go
```

Untuk melakukan run code (testing) tanpa melakukan build gunakan perintah dibawah ini
```go
go run namaFile.go
```

## Hello World (Basic Structure)
```go
package main

import "fmt"

func main() {

	fmt.Println("Hello World")

}
```

## Data Type
- String
```go
	fmt.Println("Budi Darmawan") // Budi Darmawan
	fmt.Println(len("Budi Darmawan")) // 13
	fmt.Println("Budi Darmawan"[0]) // 66 (angka ASCII dari B)
```
- Number
```go
	fmt.Println("Integer =", 1) // Integer =  1
	fmt.Println("Float =", 3.5) // Float =  3.5
```
- Boolean
```go
	fmt.Println("Benar =", true) // Benar = true
	fmt.Println("Salah =", false) // Salah = false
```

## Variable
```go
	var name string
	name = "Budi Darmawan"
	fmt.Println(name) // Budi Darmawan
	
	var age = 30
	fmt.Println(age) // 30

	country := "Indonesia"
	fmt.Println(country) // Indonesia

	var (
		firstName = "Budi"
		lastName = "Darmawan"
	)
	fmt.Println(firstName) // Budi
	fmt.Println(lastName) // Darmawan
```

## Constant
```go
	const value = 1000

	const (
		firstName string = "Budi"
		lastName	 = "Darmawan"
	)

	fmt.Println(firstName) // Budi
	fmt.Println(lastName) // Darmawan
	fmt.Println(value) // 1000
```

## Conversion
```go
	var nilai32 int32 = 129
	var nilai64 int64 = int64(nilai32)
	var nilai8 int8 =  int8(nilai32)

	fmt.Println(nilai32) // 129
	fmt.Println(nilai64) //129
	fmt.Println(nilai8) // -127 (Overflow range int8 -> -128 s.d 127)

	var name = "Budi"
	var e = name[0]
	var eString = string(e)

	fmt.Println(name) // Budi
	fmt.Println(eString) // B
```

## Type Declaration
```go
	type NoKTP string
	type Married bool

	var noKtpBudi NoKTP = "3603090710890001"
	var marriedStatus Married = true
	fmt.Println(noKtpBudi) // 3603090710890001
	fmt.Println(marriedStatus) // true
```

## Math Operation
```go
	var result = 10 + 10
	fmt.Println(result) // 20

	var a = 10
	var b = 10
	var c = a * b
	fmt.Println(c) // 100

	var i = 10
	i += 10 // i = i + 10 
	fmt.Println(i) // 20

	i++
	fmt.Println(i) // 21

	var status = true
	var notStatus = !status
	fmt.Println(status) // true
	fmt.Println(notStatus) // false

	var negatif = -100
	var positif = 100
	fmt.Println(negatif) // -100
	fmt.Println(positif) //100
```

## Comparation Operator
```go
	var name1 = "Budi"
	var name2 = "budi"

	var result bool = name1 == name2
	fmt.Println(result) // false

	var value1 = 100
	var value2 = 200

	fmt.Println(value1 > value2) // false
	fmt.Println(value1 < value2) // true
	fmt.Println(value1 == value2) // false
	fmt.Println(value1 != value2) // true
```

## Boolean Operator
```go
	var ujian = 80
	var absensi = 75

	var lulusUjian = ujian >= 80
	var lulusAbsensi = absensi >= 80
	fmt.Println(lulusUjian) // true
	fmt.Println(lulusAbsensi) // false

	var lulus = lulusUjian && lulusAbsensi
	fmt.Println(lulus) // false

	fmt.Println(ujian >= 80 && absensi >= 80) // false
```

## Array
```go
	var names [3]string

	names[0] = "Budi"
	names[1] = "Darmawan"
	names[2] = "Suntree"

	fmt.Println(names[0]) // Budi
	fmt.Println(names[1]) // Darmawan
	fmt.Println(names[2]) // Suntree

	var value = [3]int {
		90,
		95,
		80,
	}

	fmt.Println(value) // [90 95 80]

	var lagi [10]string
	
	fmt.Println(len(names)) // 3
	fmt.Println(len(value)) // 3
	fmt.Println(len(lagi)) // 10
```

## Slice
```go
	var month = [...]string {
		"Januari",
		"Februari",
		"Maret",
		"April",
		"Mei",
		"Juni",
		"Juli",
		"Agustus",
		"September",
		"Oktober",
		"November",
		"Desember",
	}

	var slice1 = month[4:7]
	fmt.Println(slice1) // [Mei Juni Juli]
	fmt.Println(len(slice1)) // 3
	fmt.Println(cap(slice1)) // 8

	month[5] = "Diubah"
	fmt.Println(slice1) // [Mei Diubah Juli]

	slice1[0] = "Diganti"
	fmt.Println(month) // [Januari Februari Maret April Diganti Diubah Juli Agustus September Oktober November Desember]

	var slice2 = month[10:]
	fmt.Println(slice2) // [November Desember]

	var slice3 = append(slice2, "Tambah")
	fmt.Println(slice3) // [November Desember Tambah]
	
	fmt.Println(slice2) // [November Desember]
	fmt.Println(month) // [Januari Februari Maret April Diganti Diubah Juli Agustus September Oktober November Desember]

	newSlice := make ([]string, 2, 5)

	newSlice[0] = "Budi"
	newSlice[1] = "Darmawan"

	fmt.Println(newSlice) // [Budi Darmawan]
	fmt.Println(len(newSlice)) // 2
	fmt.Println(cap(newSlice)) // 5
	
	copySlice := make ([]string, len(newSlice), cap(newSlice))
	copy(copySlice, newSlice)
	fmt.Println(copySlice) // [Budi Darmawan]

	iniArray := [5]int {1, 2, 3, 4, 5}
	iniSlice := []int {1, 2, 3, 4, 5}

	fmt.Println(iniArray) // [1 2 3 4 5]
	fmt.Println(iniSlice) // [1 2 3 4 5]
```

## Map
```go
	person := map[string]string {
		"name" : "Budi",
		"address" : "Surabaya",
	}

	person["title"] = "Programmmer"

	fmt.Println(person) // map[address:Surabaya name:Budi title:Programmmer]
	fmt.Println(person["name"]) // Budi
	fmt.Println(person["address"]) // Surabaya

	var book map[string]string = make(map[string]string)
	book["titile"] = "Belajar Go-Lang"
	book["author"] = "Budi"
	book["ups"] = "Salah"
	fmt.Println(book) // map[author:Budi titile:Belajar Go-Lang ups:Salah]
	fmt.Println(len(book)) // 3

	delete(book, "ups")
	fmt.Println(book) // map[author:Budi titile:Belajar Go-Lang]
	fmt.Println(len(book)) // 2
```

## If Expression
```go
	var name = "Darmawan"

	if name == "Budi" {
		fmt.Println("Hello Budi")
	} else if name == "Darmawan" {
		fmt.Println("Hello Darmawan") // Hello Darmawan
	} else {
		fmt.Println("Hi, boleh kenalan?")
	}

	// short expression
	if length := len(name) ; length > 5 {
		fmt.Println("Terlalu panjang") // Terlalu panjang
	} else {
		fmt.Println("Nama sudah benar")
	}

```

## Switch Expression
```go
	name := "Darmawan"

	switch name {
	case "Budi" :
		fmt.Println("Hello Budi")
	case "Darmawan" :
		fmt.Println("Hello Darmawan") // Hello Darmawan
	default :
		fmt.Println("Hi, boleh kenalan?")
	}

	// short expression
	switch length := len(name) ; length > 5 {
	case true :
		fmt.Println("Nama terlalu panjang") // Nama terlalu panjang
	case false :
		fmt.Println("Nama sudah benar")
	}

	// switch tanpa ekspresi (seperti if)
	length := len(name)
	switch {
	case length > 10 :
		fmt.Println("Nama terlalu panjang")
	case length > 5 :
		fmt.Println("Nama lumayan panjang") // Nama lumayan panjang
	default :
		fmt.Println("Nama sudah benar")
	}
```

## For Loops
```go
	for counter := 1 ; counter <= 5 ; counter++ {
		fmt.Println("perulangan ke", counter)
	}
	/*
		perulangan ke 1
		perulangan ke 2
		perulangan ke 3
		perulangan ke 4
		perulangan ke 5
	*/

	slice := []string {"Budi", "Darmawan", "Suntree"}
	for i := 0 ; i < len(slice) ; i++ {
		fmt.Println(slice[i])
	}
	/*
		Budi
		Darmawan
		Suntree
	*/
		
	for i, value := range slice {
		fmt.Println("Index", i, "=", value)
	}
	/*
		Index 0 = Budi
		Index 1 = Darmawan
		Index 2 = Suntree
	*/
	
	// index yang tidak digunakan
	for _, value := range slice {
		fmt.Println(value)
	}
	/*
		Budi
		Darmawan
		Suntree
	*/
	
	person := make(map[string]string)
	person["nama"] = "Budi"
	person["title"] = "Programmer"

	for key, value := range person {
		fmt.Println(key, "=", value)
	}
	/*
		title = Programmer
		nama = Budi
	*/
```

## Break & Continue
```go
	for i := 0; i < 10 ; i++ {
		if i == 5 {
			break
		}
		fmt.Println("Perulangan ke", i)
	}
	/*
		Perulangan ke 0
		Perulangan ke 1
		Perulangan ke 2
		Perulangan ke 3
		Perulangan ke 4
	*/

	for i := 0; i < 10 ; i++ {
		if i % 2 == 0 {
			continue
		}
		fmt.Println("Perulangan ke", i)
	}
	/*
		Perulangan ke 1
		Perulangan ke 3
		Perulangan ke 5
		Perulangan ke 7
		Perulangan ke 9
	*/
```

## Function
```go
package main

import "fmt"

func sayHello() {
	fmt.Println("Hello")
}

func main() {

	sayHello() // Hello
	sayHello() // Hello
	sayHello() // Hello

}
```

## Function Parameter
```go
func sayHelloTo(firstName string, lastName string) {
	fmt.Println("Hello", firstName, lastName)
}

func main() {

	firstName := "Budi"
	sayHelloTo(firstName, "Darmawan") // Hello Budi Darmawan
	sayHelloTo("Iwan", "Setiawan") // Hello Iwan Setiawan

}
```

## Function Return Value
```go
func getHello(name string) string {
	if name == "" {
		return "Hello Bro"
	} else {
		return "Hello " + name
	}
}

func main() {

	result := getHello("Budi")
	fmt.Println(result) // Hello Budi

	fmt.Println(getHello("")) // Hello Bro

}
```

## Returning Multiple Value
```go
func getFullName() (string, string, int) {
	return "Budi", "Darmawan", 30
}

func main() {

	firstName, lastName, age := getFullName()
	fmt.Println(firstName) // Budi
	fmt.Println(lastName) // Darmawan
	fmt.Println(age) // 30

	namaDepan, namaBelakang, _ := getFullName()
	fmt.Println(namaDepan) // Budi
	fmt.Println(namaBelakang) // Darmawan

}
```

## Named Return Value
```go
func getFullName2() (firstName string, lastName string, age int) {
	firstName = "Budi"
	lastName = "Darmawan"
	age = 33
	return
}

func main() {

	a, b, c := getFullName2()
	fmt.Println(a) // Budi
	fmt.Println(b) // Darmawan
	fmt.Println(c) // 33

}
```

## Variadic Function
```go
func sumAll(numbers ...int) int {
	total := 0
	for _, value := range numbers {
		total += value
	}
	return total
}

func main() {

	total := sumAll(10, 90, 30, 50, 40)
	fmt.Println(total) // 220

	slice := []int{10, 20, 30, 40 ,50}
	total = sumAll(slice...)
	fmt.Println(total) // 150
	
}
```

## Function as Value
```go
func getGoodBy(name string) string {
	return "Good By " + name
}

func main() {

	sayGoodBy := getGoodBy
	result := sayGoodBy("Budi")
	fmt.Println(result) // Good By Budi

}
```

## Function as Parameter
```go
type Filter func(string) string

func sayHelloWithFilter(name string, filter Filter) {
	nameFiltered := filter(name)
	fmt.Println("Hello " + nameFiltered)
}

func spamFilter(name string) string {
	if name == "Anjing" {
		return "..."
	} else {
		return name
	}
}

func main() {

	sayHelloWithFilter("Budi", spamFilter) // Hello Budi
	sayHelloWithFilter("Anjing", spamFilter) // Hello ...

}
```

## Anonymous Function
```go
type Blacklist func(string) bool

func registerUser(name string, blacklist Blacklist) {
	if blacklist(name) {
		fmt.Println("You are blocked " + name)
	} else {
		fmt.Println("Welcome " + name)
	}
}

func main() {

	blacklist := func(name string) bool {
		return name == "admin"
	}
	
	registerUser("admin", blacklist) // You are blocked admin
	registerUser("budi", blacklist) // Welcome budi

	registerUser("root", func(name string) bool {
		return name == "root"
	})
	// You are blocked root

}
```

## Recursive Function
```go
func factorialLoop(value int) int {
	result := 1
	for i := value; i > 0; i-- {
		result *= i
	}

	return result
}

func factorilaRecursive(value int) int {
	if value == 1 {
		return 1
	} else {
		return value * factorilaRecursive(value - 1)
	}
}

func main() {

	loop := factorialLoop(5)
	fmt.Println(loop) // 120
	fmt.Println(5*4*3*2*1) // 120

	recursive := factorilaRecursive(5)
	fmt.Println(recursive) // 120

}
```

## Closures
```go
func main() {

	name := "Budi"
	counter := 0

	increment := func() {

		name = "Iwan"
		fmt.Println("Increment")
		counter++

	}

	increment() // Increment
	increment() // Increment
	fmt.Println(counter) // 2
	fmt.Println(name) // Iwan

}

```

## Defer in Function
```go
func logging() {
	fmt.Println("Selesai memanggil function")
}

func runApplication(value int) {
	defer logging() // tetap akan dieksekusi
	fmt.Println("Run Appliaction") // dieksekusi
	result := 10/value // error
	fmt.Println("Result", result) // tidak dieksekusi
}

func main() {

	runApplication(0)

}
/*
	Run Appliaction
	Selesai memanggil function
	panic: runtime error: integer divide by zero
*/
```

## Panic in Function
```go
func endApp() {
	fmt.Println("Aplikasi selesai")
}

func runApp(error bool) {
	defer endApp() // tetap akan dieksekusi
	if error {
		panic("APLIKASI ERROR") // panic message dieksekusi saat error
	}
	fmt.Println("Aplikasi berjalan") // tidak akan dieksekusi
}

func main() {

	runApp(true)
	fmt.Println("Program berjalan") // tidak akan dieksekusi saat terjadi error

}
/*
	Aplikasi selesai
	panic: APLIKASI ERROR
*/
```

## Recovery in Function
```go
func endApp() {
	message := recover() // untuk menangkap error dan tidak menghentikan program selanjutnya
	if message != nil {
		fmt.Println("Error dengan message", message)
	}
	fmt.Println("Aplikasi selesai")
}

func runApp(error bool) {
	defer endApp()
	if error {
		panic("APLIKASI ERROR")
	}
	fmt.Println("Aplikasi berjalan")
}

func main() {

	runApp(true)
	fmt.Println("Program berjalan") // tetap di eksekusi karena panic telah di recover

}
/*
	Error dengan message APLIKASI ERROR
	Aplikasi selesai
	Program berjalan
*/
```

## Comment
```go
// ini komentar single line

/**
ini
komentar
multi
lane
*/
```

## Struct
```go
type Customer struct {
	Name, Address string
	Age int
}

func main() {

	// Cara input property dengan (=)
	var budi Customer
	budi.Name = "Budi Darmawan"
	budi.Address = "Surabaya"
	budi.Age = 30

	fmt.Println(budi) // {Budi Darmawan Surabaya 30}
	fmt.Println(budi.Name) // Budi Darmawan
	fmt.Println(budi.Address) // Surabaya
	fmt.Println(budi.Age) // 30

	// Cara key-value dengan (:)
	iwan := Customer {
		Name : "Iwan Setiawan",
		Address : "Bandung",
		Age : 35,
	}
	fmt.Println(iwan) // {Iwan Setiawan Bandung 35}

	// Cara langsung
	// tidak disarankan karena sangat tergantung urutan prototype
	wati := Customer { "Wati", "Tangerang", 25 }
	fmt.Println(wati) // {Wati Tangerang 25}

}
```

## Struct Method
```go
type Customer struct {
	Name, Address string
	Age int
}

func (customer Customer) sayHi(name string) {
	fmt.Println("Hello", name, "my name is", customer.Name)
}

func main() {

	var budi Customer
	budi.Name = "Budi Darmawan"
	budi.Address = "Surabaya"
	budi.Age = 33

	budi.sayHi("Iwan") // Hello Iwan my name is Budi Darmawan

}
```

## Interface
```go
type HasName interface {
	GetName() string
}

func SayHello(hasName HasName)  {
	fmt.Println("Hello", hasName.GetName())
}

// Person struct
type Person struct {
	Name string
}

func (person Person) GetName() string {
	return person.Name
}

// Animal struct
type Animal struct {
	Name string
}

func (animal Animal) GetName() string {
	return animal.Name
}

func main() {

	var budi Person
	budi.Name = "Budi Darmawan"

	SayHello(budi) // Hello Budi Darmawan

	cat := Animal {
		Name : "Push",
	}

	SayHello(cat) // Hello Push

}
```

## Interface Kosong
```go
func Ups(i int) interface {} {
	if i == 1 {
		return 1
	} else if i == 2 {
		return true
	} else {
		return "Ups"
	}
}

func main() {

	var data interface{} = Ups(1)
	fmt.Println(data) // 1

	data = Ups(2)
	fmt.Println(data) // true

	data = Ups(3)
	fmt.Println(data) // Ups

```

## Nil
```go
func NewMap(name string) map[string]string {
	if name == "" {
		return nil
	} else {
		return map[string]string {
			"name" : name,
		}
	}
}

func main() {

	person := NewMap("Budi")
	fmt.Println(person) // map[name:Budi]

}
```

## Interface Error
```go
import "errors"
import "fmt"

func Pembagi(nilai int, pembagi int) (int, error) {
	if pembagi == 0 {
		return 0, errors.New("Pembagi tidak boleh 0")
	} else {
		result := nilai / pembagi
		return result, nil
	}
}

func main() {

	hasil, err := Pembagi(100, 0)
	if err == nil {
		fmt.Println("Hasil", hasil)
	} else {
		fmt.Println("Error", err.Error()) // Error Pembagi tidak boleh 0
	}

}
```


## Type Assertions
```go
func random() interface{} {
	return true
}

func main() {

	var result interface{} = random()
	// var resultString = result.(string)
	// fmt.Println(resultString)

	switch value := result.(type) {
	case string :
		fmt.Println("Value", value, "is string")
	case int :
		fmt.Println("Value", value, "is int")
	default :
		fmt.Println("Unknown type") // Unknown type
	}

}
```

## Pointer
```go
type Address struct {
	City, Province, Country string
}

func main() {

	// Pass by value
	address1 := Address{"Bandung", "Jawa Barat", "Indonesia"}
	address2 := address1
	address2.City = "Subang" //? perubahan address2 TIDAK MENGUBAH reference (address1)

	fmt.Println(address1) // {Bandung Jawa Barat Indonesia}
	fmt.Println(address2) // {Subang Jawa Barat Indonesia}

	// Pass by reference -> Pointer (&)
	address3 := Address{"Surabaya", "Jawa Timur", "Indonesia"}
	address4 := &address3
	address4.City = "Lamongan" // perubahan address4 MENGUBAH reference (address3)

	fmt.Println(address3) // {Lamongan Jawa Timur Indonesia}
	fmt.Println(address4) // &{Lamongan Jawa Timur Indonesia}

	// Assign nilai baru TIDAK MENGUBAH reference
	address5 := Address{"Tangerang", "Banten", "Indonesia"}
	address6 := &address5
	address6 = &Address{"Yogyakarta", "DIY", "Indonesia"}

	fmt.Println(address5) // {Tangerang Banten Indonesia}
	fmt.Println(address6) // &{Yogyakarta DIY Indonesia}

	// Assign nilai baru MENGUBAH reference dengan (*)
	address7 := Address{"Pontianak", "Kalimantan Barat", "Indonesia"}
	address8 := &address7
	*address8 = Address{"Samarinda", "Kalimantan Timur", "Indonesia"}

	fmt.Println(address7) // {Samarinda Kalimantan Timur Indonesia}
	fmt.Println(address8) // &{Samarinda Kalimantan Timur Indonesia}

	var address9 *Address = new(Address)
	address9.City = "Jakarta"
	fmt.Println(address9) // &{Jakarta  }
	
}
```

## Pointer in Function
```go
type Address struct {
	City, Province, Country string
}

func ChangeCountryToINdonesia(address *Address) { // Tambahkan *
	address.Country = "Indonesia"
}

func main() {

	var address10 = Address {
		City : "Subang",
		Province : "Jawa Barat",
		Country : "",
	}

	ChangeCountryToINdonesia(&address10) // Tambahkan &

	fmt.Println(address10) // {Subang Jawa Barat Indonesia}
	
}
```

## Pointer in Method
```go
type Man struct {
	Name string
}

func (man *Man) Merried() { // Tambahkan *
	man.Name = "Mr. " + man.Name
}

func main() {

	budi := Man{"Budi"}
	budi.Merried()
	fmt.Println(budi.Name) // Mr. Budi

}
```

## Import
```go
import "01p_belajar_golang_dasar/helper"

func main() {

	helper.SayHello("Budi") // Hello Budi

}
```

## Access Modifier
```go
import "01p_belajar_golang_dasar/helper"
import "fmt"

func main() {

	helper.SayHello("Budi") // Hello Budi
	// helper.sayGoodBye("Budi") // error
	fmt.Println(helper.Application) // Belajar Golang Dasar
	// fmt.Println(helper.version) // error

}
```

## Package Initialization
```go
import "01p_belajar_golang_dasar/database"
// import _ "01p_belajar_golang_dasar/database" // blank identifier (_)
import "fmt"

func main() {

	result := database.GetDatabase()
	fmt.Println(result)

}
/*
	Init dipanggil
	MySQL
*/
```

## Package OS
```go
import "os"
import "fmt"

func main() {

	// Args
	args := os.Args
	fmt.Println("Arguments : ") // Arguments :
	fmt.Println(args) // [C:\Users\Owner\AppData\Local\Temp\go-build2431035763\b001\exe\47_package-os.exe]

	// Hostname
	name, err := os.Hostname()
	if err == nil {
		fmt.Println("Hostname : ", name) // Hostname :  LAPTOP-XXXXX000
	} else {
		fmt.Println("Error ; ", err.Error())
	}

	// Environment variables
	username := os.Getenv("APP_USERNAME")
	password := os.Getenv("APP_PASSWORD")

	fmt.Println(username)
	fmt.Println(password)

	// export APP_USERNAME=root
	// export APP_PASSWORD=root

}
```

## Package Flag
```go
import "flag"
import "fmt"

func main() {

	var host *string = flag.String("host", "localhost", "Put your database host")
	var username *string = flag.String("username", "root", "Put your database username")
	var password *string = flag.String("password", "root", "Put your database password")
	var number *int = flag.Int("number", 100, "Put your number")

	flag.Parse() // untuk memparsing data masukan

	fmt.Println("Host : ", *host) // Host :  localhost
	fmt.Println("Username : ", *username) // Username :  root
	fmt.Println("Password : ", *password) // Password :  root
	fmt.Println("Number : ", *number) // Number :  100

	// go run .\48_package-flag.go -username=budi -number=budi
	// Akan menghasilkan error dan instruksi pengisian

}
```

## Package String
```go
import "fmt"
import "strings"

func main() {

	fmt.Println(strings.Contains("Budi Darmawan", "Budi")) // true
	fmt.Println(strings.Contains("Budi Darmawan", "Iwan")) // false

	fmt.Println(strings.Split("Budi Darmawan", " ")) // [Budi Darmawan]

	fmt.Println(strings.ToLower("Budi Darmawan")) // budi darmawan
	fmt.Println(strings.ToUpper("Budi Darmawan")) // BUDI DARMAWAN
	fmt.Println(strings.ToTitle("Budi Darmawan")) // BUDI DARMAWAN

	fmt.Println(strings.Trim("     Budi Darmawan     ", " ")) // Budi Darmawan

	fmt.Println(strings.ReplaceAll("Budi Budi Budi Iwan Wati", "Budi", "Darmawan")) // Darmawan Darmawan Darmawan Iwan Wati

}
```

## Package Strconv
```go
import "strconv"
import "fmt"

func main() {

	// String to other type
	boolean, err := strconv.ParseBool("true")
	if err == nil {
		fmt.Println(boolean) // true
	} else {
		fmt.Println(err.Error())
	}

	number, err := strconv.ParseInt("1000000", 10, 64)
	if err == nil {
		fmt.Println(number) // 1000000
	} else {
		fmt.Println(err.Error())
	}
	
	valueInt, _ := strconv.Atoi("2000000")
	fmt.Println(valueInt) // 2000000

	// Other Type to string
	value := strconv.FormatInt(1000000, 10)
	fmt.Println(value) // 1000000

	valueString := strconv.Itoa(45)
	fmt.Println(valueString) // 45

}
```

## Package Math
```go
import "math"
import "fmt"

func main() {

	fmt.Println(math.Round(1.7)) // 2
	fmt.Println(math.Round(1.3)) // 1
	fmt.Println(math.Floor(1.7)) // 1
	fmt.Println(math.Ceil(1.3)) // 2

	fmt.Println(math.Max(10, 20)) // 20
	fmt.Println(math.Min(10, 20)) // 10

}
```

## Package Container List
```go
import "container/list"
import "fmt"

func main() {

	data := list.New()

	data.PushBack("Budi")
	data.PushBack("Darmawan")
	data.PushFront("Suntree")

	// menampilkan data pertama atau terakhir
	fmt.Println(data.Front().Value) // Suntree
	fmt.Println(data.Back().Value) // Darmawan

	// menampilkan data ujung (nil)
	fmt.Println(data.Front().Prev()) // <nil>
	fmt.Println(data.Back().Next()) // <nil>

	// dari depan ke belakang
	for element := data.Front(); element != nil; element = element.Next() {
		fmt.Println(element.Value)
	}
	/*
		Suntree
		Budi
		Darmawan
	*/

	// dari belakang ke depan
	for element := data.Back(); element != nil; element = element.Prev() {
		fmt.Println(element.Value)
	}
	/*
		Darmawan
		Budi
		Suntree
	*/
}
```

## Package Container Ring
```go
import "container/ring"
import "strconv"
import "fmt"

func main() {

	// var data *ring.Ring = ring.New(5)
	data := ring.New(5)

	// cara input manual
	// data.Value = "Budi"
	// var data2 = data.Next();
	// data2.Value = "Darmawan"

	// cara input dengan iterasi
	for i := 0; i < data.Len(); i++ {
		data.Value = "Data " + strconv.FormatInt(int64(i), 10)
		data = data.Next()
	}

	// mencetak seluruh data ring
	data.Do(func(value interface{}){
		fmt.Println(value)
	})
	/*
		Data 0
		Data 1
		Data 2
		Data 3
		Data 4
	*/
}
```

## Package Sort
```go
import "sort"
import "fmt"

type User struct {
	Name string
	Age int
}

// membuat struct menjadi array
type UserSlice []User

// membuat interface untuk Len()
func (value UserSlice) Len() int {
	return len(value)
}

// membuat interface untuk Less(i, j int)
func (value UserSlice) Less(i, j int) bool {
	return value[i].Age <  value[j].Age
}

// membuat interface untuk Swap(i, j int)
func (value UserSlice) Swap(i, j int) {
	value[i], value[j] = value[j], value[i]
}

func main() {

	users := []User {
		{"Budi", 30},
		{"Iwan", 35},
		{"Wati", 25},
		{"Ani", 20},
		{"Andi", 15},
	}

	sort.Sort(UserSlice(users))

	fmt.Println(users) // [{Andi 15} {Ani 20} {Wati 25} {Budi 30} {Iwan 35}]

}
```

## Package Time
```go
import "time"
import "fmt"

func main() {

	// waktu saat ini
	now := time.Now()

	fmt.Println(now) // 2022-10-09 13:06:25.5383441 +0700 +07 m=+0.003744201
	fmt.Println(now.Year()) // 2022
	fmt.Println(now.Month()) // October
	fmt.Println(now.Day()) // 9
	fmt.Println(now.Hour()) // 13
	fmt.Println(now.Minute()) // 6
	fmt.Println(now.Second()) // 25
	fmt.Println(now.Nanosecond()) // 538344100

	// mengeset tanggal
	utc := time.Date(2022, 10, 10, 10, 10, 10, 10, time.UTC)
	fmt.Println(utc) // 2022-10-10 10:10:10.00000001 +0000 UTC

	// parsing waktu
	layout := "2006-01-02"
	parse, _ := time.Parse(layout, "2020-10-01")
	fmt.Println(parse) // 2020-10-01 00:00:00 +0000 UTC

}
```

## Package Reflect
```go
import "reflect"
import "fmt"

type Sample struct {
	Name string `required:"true" max:"10"`
}

type ContohLagi struct {
	Name string `required="true"`
	Description string
}

// fungsi untuk validasi
func IsValid(data interface{}) bool {
	t := reflect.TypeOf(data)
	for i := 0; i < t.NumField(); i++ {
		field := t.Field(i)
		if field.Tag.Get("required") == "true" {
			value := reflect.ValueOf(data).Field(i).Interface()
			if value == "" {
				return false
			}
		}
	}
	return true
}

func main() {

	sample := Sample{"Budi"}

	var sampleType = reflect.TypeOf(sample)

	fmt.Println(sampleType.NumField()) // 1
	fmt.Println(sampleType.Field(0).Name) // Name
	fmt.Println(sampleType.Field(0).Tag.Get("required")) // true
	fmt.Println(sampleType.Field(0).Tag.Get("max")) // 10
	fmt.Println(sampleType.Field(0).Tag.Get("min")) // kososng karena tidak ada tag min

	// contoh validasi
	sample.Name = ""
	fmt.Println(IsValid(sample)) // false

	contoh := ContohLagi{"Budi", ""} // true karena tidak dipasang tag required
	fmt.Println(IsValid(contoh)) // true
	
}
```

## Package Regexp
```go
import "regexp"
import "fmt"

func main() {

	var regex *regexp.Regexp = regexp.MustCompile("e([a-z])a")
	fmt.Println(regex.MatchString("eka")) // true
	fmt.Println(regex.MatchString("eta")) // true
	fmt.Println(regex.MatchString("eDa")) // false

	search := regex.FindAllString("eka eko eda eta eya eki", -1)
	fmt.Println(search) // [eka eda eta eya]
}
```

##
##

# Heading 1 / Judul Utama (gunakan #)

## Heading 2 / Sub Judul (gunakan ##)

Text biasa (ditulis biasa tanpa format apapun)

[Hyperlink](https://www.google.com) (nama hyperlink dibungkus kurung siku, urlnya dibungkus tanda kurung biasa)

```bash
git add .
git commit -m "baris code menggunakan backtick 3x di awal(sertakan bahasanya) dan akhir code"
git push
```

Untuk `menyoroti` bungkus text dengan backtick 1x

# Template

## Sub Judul 
```<bahasa>
git add .
git commit -m 'Update README.md'
git push

```

Update README.md