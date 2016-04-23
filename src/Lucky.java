import java.util.Scanner;

public class Lucky {
	static int userSel, n = 0, biaohao = 0;
	static String[] account = new String[10];
	static String[] password = new String[10];
	static String b;
	static int[] num = new int[10];// 用户会员卡号

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (true) {
			userSel = showMenu();// 调用showMenu（）方法获得用户输入
			switch (userSel) {
			case 1:
				System.out.println("【奖客富翁系统>注册】");
				regist();// 注册
				choice();

				break;
			case 2:
				System.out.println("【奖客富翁系统>登录】");
				load();// 登录
				choice();

				break;
			case 3:
				System.out.println("【奖客富翁系统>抽奖】");
				choujiang();// 抽奖
				choice();
				break;
			case 4:
				System.out.println("系统退出，谢谢使用！");// 结束程序
				break;
			default:
				System.out.println("输入数字不正确！");
				break;
			}
			if (userSel == 4) {
				break;
			} // 当用户输入4时，退出while循环，结束程序

		}
	}

	public static int showMenu() {
		System.out.println("*****欢迎进入奖客富翁系统*****");
		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("3.抽奖");
		System.out.println("*****************************");
		System.out.println("请选择菜单：");
		Scanner input = new Scanner(System.in);
		userSel = input.nextInt();
		return userSel;
	}

	public static void regist() {// 注册
		Scanner input = new Scanner(System.in);
		System.out.println("请填写个人注册信息：");
		System.out.println("用户名：");
		account[biaohao] = input.nextLine();
		System.out.println("密码：");
		password[biaohao] = input.nextLine();
		num[biaohao] = (int) ((int) 10 * Math.random());
		System.out.println("注册成功，请记好您的会员卡号");
		// System.out.println("您的会员卡号是："+num[biaohao]);
		System.out.println("用户名" + "           " + "密码" + "        " + "会员卡号");
		System.out.println(account[biaohao] + "    " + password[biaohao] + "    " + num[biaohao]);
		biaohao++;

	}

	public static void load() {// 登录

		Scanner input = new Scanner(System.in);

		System.out.println("请输入用户名：");
		String Account = input.nextLine();// 当前输入账号
		for (int i = 0; i < account.length; i++) {
			if (Account.equals(account[i]) == true) {
				System.out.println("请输入密码：");
				biaohao = i;
				break;
			} else {
				System.out.println("用户名输入错误或未注册");
			}
		}
		String Password = input.nextLine();// 当前输入密码
		if (Password.equals(password[biaohao]) != true) {
			System.out.println("密码错误！请重新登录。");
		}else
		System.out.println("欢迎您：" + account[biaohao]);
	}

	private static void choujiang() {// 抽奖
		int[] luckyNumber = new int[5];
		System.out.println("您的卡号：" + num[biaohao]);
		System.out.println("本日的幸运数字为：");
		for (int i = 0; i < luckyNumber.length; i++) {
			luckyNumber[i] = (int) ((int) 10 * Math.random());
			for (int j = 0; j < i; j++) {
				if (luckyNumber[j] == luckyNumber[i]) {
					luckyNumber[i] = (int) ((int) 10 * Math.random());
				}
			}
			System.out.print(luckyNumber[i] + " ");
		}
		boolean flag = false;
		for (int k = 0; k < luckyNumber.length; k++) {
			if (num[biaohao] == luckyNumber[k]) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("恭喜您成为本日的幸运会员！");
		} else {
			System.out.println("抱歉！您不是本日的幸运会员！");
		}
	}

	private static void choice() {
		System.out.println("要继续吗？（Y/N）：");
		Scanner input = new Scanner(System.in);
		String b = input.nextLine();
		if (b.equalsIgnoreCase("N")) {
			System.out.println("系统退出，谢谢使用！");
		}
	}
}
