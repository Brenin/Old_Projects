using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace KiwiLön {
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window {

		private int _startTid;
		private int _stoppTid;
		private int _totalHours;
		private double _tax;
		private int _totalNormalHours;
		private int _totalLockHours;
		
		private double _salary;
		private double _totalBeforeTax;
		private int _totalAfterTax;

		private bool _checked = false;

		public MainWindow() {
			InitializeComponent();
		}

		private void reset_Click(object sender, RoutedEventArgs e) {
			ClearThings();
			DisplayBox.Text = "";

			Salary = 0;
			Tax = 0;
			HoursBasic = 0;
			HoursBasicLock = 0;
			Hours22 = 0;
			Hours22Lock = 0;
			Hours45 = 0;
			Hours45Lock = 0;
			Hours90 = 0;
			Hours90Lock = 0;

			_salary = 0;
			_totalBeforeTax = 0;
			_totalAfterTax = 0;
		}

		private void info_Click(object sender, RoutedEventArgs e) {

			Info info = new Info();
			info.Show();
		}

		private void HourWeekday_Click(object sender, RoutedEventArgs e) {

			Int32.TryParse(textBoxW1.Text, out _startTid);
			Int32.TryParse(textBoxW2.Text, out _stoppTid);

			_checked = checkBoxW.IsChecked.Value && checkBoxW.IsChecked.HasValue;

			WeekdaySalary(_startTid, _stoppTid, _checked);

			DisplayBoxPrint();
		}

		private void HourSaturday_Click(object sender, RoutedEventArgs e) {

			Int32.TryParse(textBoxSa1.Text, out _startTid);
			Int32.TryParse(textBoxSa2.Text, out _stoppTid);

			_checked = checkBoxSa.IsChecked.Value && checkBoxSa.IsChecked.HasValue;

			SaturdaySalary(_startTid, _stoppTid, _checked);

			DisplayBoxPrint();
		}

		private void HourSunday_Click(object sender, RoutedEventArgs e) {

			Int32.TryParse(textBoxSu1.Text, out _startTid);
			Int32.TryParse(textBoxSu2.Text, out _stoppTid);

			_checked = checkBoxSu.IsChecked.Value && checkBoxSu.IsChecked.HasValue;

			SundaySalary(_startTid, _stoppTid, _checked);

			DisplayBoxPrint();
		}

		private void Salary_Click(object sender, RoutedEventArgs e) {

			Double.TryParse(textBoxSalary.Text, out _salary);
			Salary = _salary;

			DisplayBoxPrint();
		}

		private void Taxes_Click(object sender, RoutedEventArgs e) {

			double.TryParse(textBoxTaxes.Text, out _tax);
			var tmp = _tax / 100;
			Tax = tmp;

			DisplayBoxPrint();
		}

		private void DisplayBoxPrint() {
			ClearThings();
			TotalHours();
			TotalBeforeTax();
			TotalTax();

			var print = "Vanliga: \t\t\t\t" + HoursBasic +
						"\n+22: \t\t\t\t" + Hours22 +
						"\n+45: \t\t\t\t" + Hours45 +
						"\n+90: \t\t\t\t" + Hours90 +
						"\nLås timmar: " +
						"\nVanliga: \t\t\t\t" + HoursBasicLock +
						"\n+22: \t\t\t\t" + Hours22Lock +
						"\n+45: \t\t\t\t" + Hours45Lock +
						"\n+90: \t\t\t\t" + Hours90Lock +
						"\n\nTotala timmar: \t\t\t" + _totalHours +
						"\nLön/h: \t\t\t\t" + Salary + 
						"\nLön före skatt: \t\t\t" + _totalBeforeTax +
						"\nLön efter skatt: \t\t\t" + _totalAfterTax
						;

			DisplayBox.Text = print;
		}

		private void TotalHours() {
			_totalLockHours = HoursBasicLock + Hours22Lock + Hours45Lock + Hours90Lock;
			_totalNormalHours = HoursBasic + Hours22 + Hours45 + Hours90;

			_totalHours = _totalNormalHours + _totalLockHours;
		}

		private void TotalBeforeTax() {

			if (Salary != 0) {
				_totalBeforeTax = OvertimeOrNot(_totalHours);
			}
		}

		private void TotalTax() {
			if (Tax != 0 && _totalBeforeTax != 0) {
				var amountToPayInTax = _totalBeforeTax * Tax;
				_totalAfterTax = (int) _totalBeforeTax - (int) amountToPayInTax;
			}
		}

		public void ClearThings() {

			textBoxW1.Clear();
			textBoxW2.Clear();
			checkBoxW.IsChecked = false;

			textBoxSa1.Clear();
			textBoxSa2.Clear();
			checkBoxSa.IsChecked = false;

			textBoxSu1.Clear();
			textBoxSu2.Clear();
			checkBoxSu.IsChecked = false;

			textBoxTaxes.Clear();
			textBoxSalary.Clear();
		}
	}
}
