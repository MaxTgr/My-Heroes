package br.com.doghero.dhproject.model;

public class Hero {

    private boolean mIsSuperHero;
    private String mFirstName;
    private String mImageUrl;
    private String mAddressNeighborhood;
    private int mPrice;

    public Hero(boolean isSuperHero, String firstName, String imageUrl, String addressNeighborhood, int price) {
        mIsSuperHero = isSuperHero;
        mFirstName = firstName;
        mImageUrl = imageUrl;
        mAddressNeighborhood = addressNeighborhood;
        mPrice = price;
    }

    public boolean getIsSuperHero() {
        return mIsSuperHero;
    }

    public void setIsSuperHero(boolean mIsSuperHero) {
        this.mIsSuperHero = mIsSuperHero;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getAddressNeighborhood() {
        return mAddressNeighborhood;
    }

    public void setAddressNeighborhood(String mAddressNeighborhood) {
        this.mAddressNeighborhood = mAddressNeighborhood;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}
