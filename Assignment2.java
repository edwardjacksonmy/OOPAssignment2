public class Assignment2 {

    // Pricing Class
    public static class Pricing {
        int adultPrice;
        int childExtraBedPrice;
        int childNoExtraBedPrice;
        int infantPrice;

        public Pricing(int adultPrice, int childExtraBedPrice, int childNoExtraBedPrice, int infantPrice) {
            this.adultPrice = adultPrice;
            this.childExtraBedPrice = childExtraBedPrice;
            this.childNoExtraBedPrice = childNoExtraBedPrice;
            this.infantPrice = infantPrice;
        }
    }

    // State Class
    public static class State {
        String name;

        public State(String name) {
            this.name = name;
        }
    }

    // Country Class
    public static class Country {
        String name;

        public Country(String name) {
            this.name = name;
        }
    }

    // Tour Class
    public static class Tour {
        State state;
        int duration;
        Pricing pricingNormal;
        Pricing pricingPeak;

        public Tour(State state, int duration, Pricing pricingNormal, Pricing pricingPeak) {
            this.state = state;
            this.duration = duration;
            this.pricingNormal = pricingNormal;
            this.pricingPeak = pricingPeak;
        }
    }

    // OverseasTour Class
    public static class OverseasTour extends Tour {
        Country country;
        boolean hasJoinedTour;
        boolean hasPrivateTour;

        public OverseasTour(Country country, State state, boolean hasJoinedTour, boolean hasPrivateTour, int duration,
                            Pricing pricingNormal, Pricing pricingPeak) {
            super(state, duration, pricingNormal, pricingPeak);
            this.country = country;
            this.hasJoinedTour = hasJoinedTour;
            this.hasPrivateTour = hasPrivateTour;
        }
    }

    // DomesticTour Class
    public static class DomesticTour extends Tour {
        boolean hasPrivateTour;
        boolean hasHoneymoonTour;

        public DomesticTour(State state, boolean hasPrivateTour, boolean hasHoneymoonTour, int duration,
                            Pricing pricingNormal, Pricing pricingPeak) {
            super(state, duration, pricingNormal, pricingPeak);
            this.hasPrivateTour = hasPrivateTour;
            this.hasHoneymoonTour = hasHoneymoonTour;
        }
    }

    public static void main(String[] args) {
        // Create Pricing objects
        Pricing overseasPricingNormal = new Pricing(4297, 4097, 3897, 500);
        Pricing overseasPricingPeak = new Pricing(5097, 4897, 4697, 500);
        Pricing domesticPricingNormal = new Pricing(1647, 1447, 1247, 500);
        Pricing domesticPricingPeak = new Pricing(2447, 2247, 2047, 500);

        // Create State and Country objects
        State seoulState = new State("Seoul");
        Country koreaCountry = new Country("Korea");
        State sabahState = new State("Sabah");

        // Create OverseasTour and DomesticTour objects
        OverseasTour overseasTour = new OverseasTour(koreaCountry, seoulState, true, true, 6, overseasPricingNormal, overseasPricingPeak);
        DomesticTour domesticTour = new DomesticTour(sabahState, true, false, 3, domesticPricingNormal, domesticPricingPeak);

        // Test the objects
        System.out.println("Overseas Tour:");
        System.out.println("Country: " + overseasTour.country.name);
        System.out.println("State: " + overseasTour.state.name);
        System.out.println("Has Joined Tour: " + overseasTour.hasJoinedTour);
        System.out.println("Has Private Tour: " + overseasTour.hasPrivateTour);
        System.out.println("Duration: " + overseasTour.duration + " days");
        System.out.println("Price for Normal Season: Adult: RM" + overseasTour.pricingNormal.adultPrice + ", Child with Extra Bed: RM" +
                overseasTour.pricingNormal.childExtraBedPrice + ", Child with No Extra Bed: RM" + overseasTour.pricingNormal.childNoExtraBedPrice +
                ", Infant: RM" + overseasTour.pricingNormal.infantPrice);
        System.out.println("Price for Peak Season: Adult: RM" + overseasTour.pricingPeak.adultPrice + ", Child with Extra Bed: RM" +
                overseasTour.pricingPeak.childExtraBedPrice + ", Child with No Extra Bed: RM" + overseasTour.pricingPeak.childNoExtraBedPrice +
                ", Infant: RM" + overseasTour.pricingPeak.infantPrice);

        System.out.println("\nDomestic Tour:");
        System.out.println("State: " + domesticTour.state.name);
        System.out.println("Has Private Tour: " + domesticTour.hasPrivateTour);
        System.out.println("Has Honeymoon Tour: " + domesticTour.hasHoneymoonTour);
        System.out.println("Duration: " + domesticTour.duration + " days");
        System.out.println("Price for Normal Season: Adult: RM" + domesticTour.pricingNormal.adultPrice + ", Child with Extra Bed: RM" +
                domesticTour.pricingNormal.childExtraBedPrice + ", Child with No Extra Bed: RM" + domesticTour.pricingNormal.childNoExtraBedPrice +
                ", Infant: RM" + domesticTour.pricingNormal.infantPrice);
        System.out.println("Price for Peak Season: Adult: RM" + domesticTour.pricingPeak.adultPrice + ", Child with Extra Bed: RM" +
                domesticTour.pricingPeak.childExtraBedPrice + ", Child with No Extra Bed: RM" + domesticTour.pricingPeak.childNoExtraBedPrice +
                ", Infant: RM" + domesticTour.pricingPeak.infantPrice);
    }
}