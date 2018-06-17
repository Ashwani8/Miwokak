package com.example.admin.miwokak;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {
    /**  Constant value that represents no image was provided for this word */

    private static final int NO_IMAGE_PROVIDED = -1;
    /** default translation of the word */
    private String mDefaultTranslation;
    /** Miwok Translation of the word */
    private  String mMiwokTranslation;
    /** Image Resource ID as an integer */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Audio resource ID for the word, audio file in res raw     */
    private int mAudioResourceId;

    /**
     * create a new Word Object
     *
     * @param defaultTranslation is the word in a language that user is familiar with
     *                           such as English
     * @param  miwokTranslation is the word in Miwok language
     *
     *  @param audioResourceId is the resource ID for the audio files associated with this word
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }

    /**
     * create a second construct
     *
     * @param defaultTranslation is the word in a language that user is familiar with
     *                           such as English
     * @param  miwokTranslation is the word in Miwok language
     *
     * @param  imageResourceId is the drawable source id for corresponding image assest
     *
     * @param audioResourceId is the resource ID for the audio files associated with this word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId,
                int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId =audioResourceId;

    }

    /**
     * get the default translation
     */

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * get the Miwok translation
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * get the image from drawable source
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     *
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;

    }

    /**
     * Returns the audio resource ID of the word
     * @return
     */
    public int getAudioResourceId(){return mAudioResourceId;}

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}

