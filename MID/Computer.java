    package MID;
    public class Computer extends Device {
        protected boolean ssd;
        protected int memory;

        public Computer(boolean ssd, int memory) {
            this.ssd = ssd;
            this.memory = memory;
        }

        public Computer(String cpu, int ram, boolean ssd, int memory) {
            super(cpu, ram);
            this.ssd = ssd;
            this.memory = memory;
        }

        public Computer(int price, String model, int count, String cpu, int ram, boolean ssd, int memory) {
            super(price, model, count, cpu, ram);
            this.ssd = ssd;
            this.memory = memory;
        }

        @Override
        double getPerformance() {
            if (ssd == true){
                return basePerformance()*1.5;
            }
            return basePerformance();
        }


        @Override
        void showDetails() {
            System.out.println("id = "+ getId() +" price = " + getPrice() + " model = " + getModel() +
                    " cpu = " + getCpu() + " ram = " + getRam() + " ssd = " + isSsd()+
                    " memory = " + getMemory());
        }



        public boolean isSsd() {
            return ssd;
        }
        public String getType(){
            return "Computer";
        }
        public void setSsd(boolean ssd) {
            this.ssd = ssd;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }
    }

