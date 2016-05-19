using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace KiwiLön {
	public partial class MainWindow {

		public double Salary { get; private set; }
		public double Tax { get; private set; }
		public int HoursBasic { get; private set; }
		public int HoursBasicLock { get; private set; }
		public int Hours22 { get; private set; }
		public int Hours22Lock { get; private set; }
		public int Hours45 { get; private set; }
		public int Hours45Lock { get; private set; }
		public int Hours90 { get; private set; }
		public int Hours90Lock { get; private set; }

		private void WeekdaySalary(int startTime, int stoppTime, bool locking) {

			if (locking) {
				for (var i = startTime; i < stoppTime; i++) {
					if (i < 18) {
						HoursBasicLock += 1;
					} else if (i >= 18 && i < 21) {
						Hours22Lock += 1;
					} else if (i >= 21) {
						Hours45Lock += 1;
					} 
				}
			} else {
				for (var i = startTime; i < stoppTime; i++) {
					if (i < 18) {
						HoursBasic += 1;
					} else if (i >= 18 && i < 21) {
						Hours22 += 1;
					} else if (i >= 21) {
						Hours45 += 1;
					} 

				}
			}
		}

		private void SaturdaySalary(int startTime, int stoppTime, bool locking) {

			if (locking) {
				for (var i = startTime; i < stoppTime; i++) {
					if (i < 13) {
						HoursBasicLock += 1;
					} else if (i >= 13 && i < 16) {
						Hours45Lock += 1;
					} else if (i >= 16) {
						Hours90Lock += 1;
					}
                }
            } else {
				for (var i = startTime; i < stoppTime; i++) {
					if (i < 13) {
						HoursBasic += 1;
					} else if (i >= 13 && i < 16) {
						Hours45 += 1;
					} else if (i >= 16) {
						Hours90 += 1;
					}

				}
            }
		}

		private void SundaySalary(int startTime, int stoppTime, bool locking) {

			var _tmp = stoppTime - startTime;
			if (locking) {
				Hours90Lock += _tmp;
			} else {
				Hours90 += _tmp;
			}
		}

		private double OvertimeOrNot(int totalHoursWorked) {
			if (totalHoursWorked <= 52) {
				return _totalBeforeTax = _totalHours * Salary;
			} else {
				var _tmp = (HoursBasic * Salary) + (Hours22 * (Salary + 22)) + 
							(Hours45 * (Salary + 45)) + (Hours90 * (Salary + 90));

				var _tmp2 = (HoursBasicLock * (Salary + 6)) + (Hours22Lock * (Salary + 28)) +
							(Hours45Lock * (Salary + 51)) + (Hours90Lock * (Salary + 96));

				return _totalBeforeTax = _tmp + _tmp2;
			}
		}
	}
}
