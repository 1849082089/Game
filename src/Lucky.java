import java.util.Scanner;

public class Lucky {
	static int userSel, n = 0, biaohao = 0;
	static String[] account = new String[10];
	static String[] password = new String[10];
	static String b;
	static int[] num = new int[10];// �û���Ա����

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (true) {
			userSel = showMenu();// ����showMenu������������û�����
			switch (userSel) {
			case 1:
				System.out.println("�����͸���ϵͳ>ע�᡿");
				regist();// ע��
				choice();

				break;
			case 2:
				System.out.println("�����͸���ϵͳ>��¼��");
				load();// ��¼
				choice();

				break;
			case 3:
				System.out.println("�����͸���ϵͳ>�齱��");
				choujiang();// �齱
				choice();
				break;
			case 4:
				System.out.println("ϵͳ�˳���ллʹ�ã�");// ��������
				break;
			default:
				System.out.println("�������ֲ���ȷ��");
				break;
			}
			if (userSel == 4) {
				break;
			} // ���û�����4ʱ���˳�whileѭ������������

		}
	}

	public static int showMenu() {
		System.out.println("*****��ӭ���뽱�͸���ϵͳ*****");
		System.out.println("1.ע��");
		System.out.println("2.��¼");
		System.out.println("3.�齱");
		System.out.println("*****************************");
		System.out.println("��ѡ��˵���");
		Scanner input = new Scanner(System.in);
		userSel = input.nextInt();
		return userSel;
	}

	public static void regist() {// ע��
		Scanner input = new Scanner(System.in);
		System.out.println("����д����ע����Ϣ��");
		System.out.println("�û�����");
		account[biaohao] = input.nextLine();
		System.out.println("���룺");
		password[biaohao] = input.nextLine();
		num[biaohao] = (int) ((int) 10 * Math.random());
		System.out.println("ע��ɹ�����Ǻ����Ļ�Ա����");
		// System.out.println("���Ļ�Ա�����ǣ�"+num[biaohao]);
		System.out.println("�û���" + "           " + "����" + "        " + "��Ա����");
		System.out.println(account[biaohao] + "    " + password[biaohao] + "    " + num[biaohao]);
		biaohao++;

	}

	public static void load() {// ��¼

		Scanner input = new Scanner(System.in);

		System.out.println("�������û�����");
		String Account = input.nextLine();// ��ǰ�����˺�
		for (int i = 0; i < account.length; i++) {
			if (Account.equals(account[i]) == true) {
				System.out.println("���������룺");
				biaohao = i;
				break;
			} else {
				System.out.println("�û�����������δע��");
			}
		}
		String Password = input.nextLine();// ��ǰ��������
		if (Password.equals(password[biaohao]) != true) {
			System.out.println("������������µ�¼��");
		}else
		System.out.println("��ӭ����" + account[biaohao]);
	}

	private static void choujiang() {// �齱
		int[] luckyNumber = new int[5];
		System.out.println("���Ŀ��ţ�" + num[biaohao]);
		System.out.println("���յ���������Ϊ��");
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
			System.out.println("��ϲ����Ϊ���յ����˻�Ա��");
		} else {
			System.out.println("��Ǹ�������Ǳ��յ����˻�Ա��");
		}
	}

	private static void choice() {
		System.out.println("Ҫ�����𣿣�Y/N����");
		Scanner input = new Scanner(System.in);
		String b = input.nextLine();
		if (b.equalsIgnoreCase("N")) {
			System.out.println("ϵͳ�˳���ллʹ�ã�");
		}
	}
}
