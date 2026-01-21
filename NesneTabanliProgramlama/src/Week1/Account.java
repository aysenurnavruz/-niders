package Week1;

public class Account {
        private String name;//instance variable, private olmasının sebebi ise bunun erişimini engellemek.
        //şuan herhangi bir değer vermediğim için null ama istersek bunabir değer atayıp name="guest
        //gibi o zaman bu durumda kullanıcı ilk değeri girmeden her zaaman guest verir.

        private int id;//java Stringlerin ilk değerine null verir integerların 0 verir. güvenlik için.

        public String getName() {
            return name;
        }
        //get ve set  kullanmamızın sebebi validate edebiliriz. kontrol sağlıyor aslında.
        //amacımız kontrolü elimizde tutmak ve geçersiz değerlerden kaçınmak.
        public void setName(String name) {
            //validate burada edilir
            //if validation==true
            this.name = name;
            //else
            //düzenli değer gir şeklinde validate edebiliriz.
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


