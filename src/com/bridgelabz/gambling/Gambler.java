package com.bridgelabz.gambling;

public class Gambler {

	double stake;
	int wonDays, loseDays;

	double maxAmountWin;
	double maxAmountLoose;

	double[] winLose = new double[20];

	public void placeBet() {
		int betAmt = 1;

		int winOrLose = (int) (Math.random() * 2);

		if (winOrLose == 1) {
			stake += betAmt;
		} else {
			stake -= betAmt;
		}
	}

	public void gamble() {
		double halfStake = stake / 2;
		double winLimit = stake + stake / 2;

		while (stake > halfStake && stake < winLimit) {
			placeBet();
		}
		if (stake == winLimit) {
			wonDays++;
			if (maxAmountWin < halfStake) {
				maxAmountWin = halfStake;
			}
		} else {
			loseDays++;
			if (maxAmountLoose < halfStake)
				maxAmountLoose = halfStake;
		}
	}

	public static void main(String[] args) {

		Gambler gambler = new Gambler();

		for (int i = 0; i < 20; i++) {
			gambler.stake += 100;
			double initStake = gambler.stake;
			gambler.gamble();
			gambler.winLose[i] = gambler.stake - initStake;
			System.out.println("After Day " + (i + 1) + " : " + gambler.stake);
		}

		System.out.println("After playing for a day, gambler's remaining stake : $"
				+ gambler.stake + " USD");
		System.out.println("Won count : " + gambler.wonDays);
		System.out.println("Lose count : " + gambler.loseDays);

		System.out.println("Max amt won : " + gambler.maxAmountWin);
		System.out.println("Max amt loose : " + gambler.maxAmountLoose);
		int luckyDay = 0, unLuckyDay = 0;
		for (int i = 0; i < gambler.winLose.length; i++) {
			if (gambler.winLose[i] == gambler.maxAmountWin) {
				luckyDay = i + 1;
			}
			if (Math.abs(gambler.winLose[i]) == gambler.maxAmountLoose) {
				unLuckyDay = i + 1;
			}
		}
		System.out.println("Lucky day : " + luckyDay);
		System.out.println("Unlucky day : " + unLuckyDay);
	}
}