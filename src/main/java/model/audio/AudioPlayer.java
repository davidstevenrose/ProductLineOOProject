package model.audio;

import model.ItemType;
import model.MultimediaControl;
import model.Product;

public class AudioPlayer extends Product implements MultimediaControl {

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
    this.type = ItemType.Audio.toString();
  }

  public AudioPlayer(String name, String manufacturer) {
    this(name, manufacturer, "N/A", "N/A");
  }

  @Override
  public void play() {
    System.out.println(name + " is playing.");
  }

  @Override
  public void stop() {
    System.out.println(name + " has stopped playing.");
  }

  @Override
  public void previous() {
    System.out.println(name + " is playing the previous media.");
  }

  @Override
  public void next() {
    System.out.println(name + " is playing the next media.");
  }

  @Override
  public String toString() {
    String output = super.toString() + "\n";
    output += "Supported Audio Formats: " + supportedAudioFormats + "\n";
    output += "Supported Playlist Formats: " + supportedPlaylistFormats;
    return output;
  }

  public String getSupportedAudioFormats() {
    return supportedAudioFormats;
  }

  public void setSupportedAudioFormats(String supportedAudioFormats) {
    this.supportedAudioFormats = supportedAudioFormats;
  }

  public String getSupportedPlaylistFormats() {
    return supportedPlaylistFormats;
  }

  public void setSupportedPlaylistFormats(String supportedPlaylistFormats) {
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }
}