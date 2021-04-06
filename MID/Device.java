package MID;

    public abstract class Device extends Good {
        protected String cpu;
        protected int ram;


        public double basePerformance() {
            switch (cpu) {
                case "corei3":
                    return 1.3*ram;

                case "corei5":
                    return 1.7*ram;

                case "corei7":
                    return 2.1*ram;

                case "corei9":
                    return 2.5*ram;

            }
            return 0;
        }


        abstract double getPerformance();

        abstract String getType();
        @Override
        void getSale() {
            System.out.println("The number of item that have been sold: " + getSold());
        }

        public Device() {
        }

        public Device(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Device(int price, String model, int count, String cpu, int ram) {
            super(price, model, count);
            this.cpu = cpu;
            this.ram = ram;
        }

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public int getRam() {
            return ram;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }
    }

