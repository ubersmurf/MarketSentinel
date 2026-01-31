import matplotlib.pyplot as plt
import pandas

df = pandas.read_csv("data/market_data.csv")

plt.figure()
plt.plot(df["Timestamp"], df["Price"], marker='o')
plt.xticks(rotation=45)
plt.xlabel("Time")
plt.ylabel("Price")
plt.title("MarketSentinel Analysis - BTC")
plt.tight_layout()
plt.savefig("data/chart.png")