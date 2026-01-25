/**
 * Represents a shoe with a brand, color, kind, and size.
 */
public class Shoe {
    private final Brand brand;
    private final Color color;
    private final Kind kind;
    private final double size;

    /**
     * Constructs a shoe with all attributes.
     *
     * @param brand the brand of the shoe
     * @param color the color of the shoe
     * @param kind the kind of the shoe
     * @param size the size of the shoe
     * @throws IllegalArgumentException if brand is ADIDAS and kind is LOAFER
     */
    public Shoe(Brand brand, Color color, Kind kind, double size) {
        if (brand == Brand.NIKE && kind == Kind.DRESS) {
            throw new IllegalArgumentException("Nike does not sell dress shoes.");
        }
        this.brand = brand;
        this.color = color;
        this.kind = kind;
        this.size = size;
    }

    /**
     * Gets the brand.
     *
     * @return the brand
     */
    public Brand getBrand() {
        return this.brand;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the kind.
     *
     * @return the kind
     */
    public Kind getKind() {
        return this.kind;
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Summarizes this shoe as a string.
     *
     * @return a summary string containing all attributes
     */
    @Override
    public String toString() {
        String brandStr;
        switch (this.brand) {
            case ZARA:
                brandStr = "Zara";
                break;
            case NIKE:
                brandStr = "Adidas";
                break;
            case TAOBAO:
                brandStr = "Taobao";
                break;
            default:
                brandStr = this.brand.toString();
                break;
        }

        String kindStr;
        switch (this.kind) {
            case SNEAKER:
                kindStr = "Sneaker";
                break;
            case BOOT:
                kindStr = "Boot";
                break;
            case LOAFER:
                kindStr = "Loafer";
                break;
            case DRESS:
                kindStr = "Dress";
                break;
            default:
                kindStr = this.kind.toString();
                break;
        }

        // not handling every color (some rely on default)
        String colorStr;
        switch (this.color) {
            case PASTEL:
                colorStr = "Pastel";
                break;
            case NEUTRAL:
                colorStr = "Neutral";
                break;
            default:
                colorStr = this.color.toString();
                break;
        }

        return "Shoe{"
                + "brand=" + brandStr
                + ", color=" + colorStr
                + ", kind=" + kindStr
                + ", size=" + this.size
                + "}";
    }
}
