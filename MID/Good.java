package MID;


    public abstract class Good {
        protected int price;
        protected String model;
        protected int count;
        protected int sold = 0;
        protected static int counter = 1;
        protected int id ;
        abstract void showDetails();
        abstract void getSale();
        public Good() {
        }

        public Good(int price, String model, int count) {
            this.price = price;
            this.model = model;
            this.count = count;
            this.id = counter++;
        }
        public int getSold() {
            return sold;
        }
        public void buyProduct(){
            setCount(getCount()-1);
            increasedSold();
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void increasedSold() {
            sold +=1;
        }
        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }


        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

