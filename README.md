
# NCryptocurrency

A Powerful Cryptocurrency API for Minecraft Plugins and Java Projects

This API brings powerful cryptocurrency data capabilities to your Java and Minecraft projects, making it easy to integrate real-time cryptocurrency prices and market information from some of the most popular platforms: CoinGecko and Binance.

Real-Time Data: Get up-to-the-minute cryptocurrency prices with just a few lines of code.
Easy Integration: The API has been designed to be intuitive and simple to use in your Java-based applications or Minecraft plugins. Fetching cryptocurrency data has never been easier.​



## Access

Maven

```bash
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.NotPatch</groupId>
    <artifactId>nCryptocurrency</artifactId>
    <version>1.1</version>
</dependency>
```
Gradle
  
```bash
dependencies {
    implementation 'com.github.NotPatch:nCryptocurrency:1.1'
}
```
## Usage

```bash
NCryptocurrency.getCoinGeckoPrice(crypto, currency);
NCryptocurrency.getBinancePrice(crypto, currency);
```
