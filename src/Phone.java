/**
 * Created by Artomov on 18.12.2014.
 */

public class Phone {
    private final String vendor;
    private final String model;
    private final int screenSize;

    public int getScreenSize() {
        return screenSize;
    }

    public String getModel() {
        return model;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (screenSize != phone.screenSize) return false;
        if (model != null ? !model.equals(phone.model) : phone.model != null) return false;
        if (vendor != null ? !vendor.equals(phone.vendor) : phone.vendor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vendor != null ? vendor.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + screenSize;
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", screen=" + screenSize +
                '}';
    }

    private Phone(Builder builder) {
        vendor = builder.vendor;
        model = builder.model;
        screenSize = builder.screenSize;
    }

    public static class Builder {
        private String vendor;
        private String model;
        private int screenSize;
        //
        // default Builder constructor (initialize all fields):
        public Builder() {
            this.vendor = "BEST_SOFT";
            this.model = "?";
            this.screenSize = 8;
        }
        //
        // additional Builder(Phone) constructor:
        public Builder(Phone original) {
            this.vendor = original.vendor;
            this.model = original.model;
            this.screenSize = original.screenSize;
        }

        public Builder vendor(String newVendor) {
            this.vendor = newVendor;
            return this;
        }

        public Builder model(String newModel) {
            this.model = newModel;
            return this;
        }

        public Builder screenSize(int newScreenSize) {
            this.screenSize = newScreenSize;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}
