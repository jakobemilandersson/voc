import calendar

from unittest import expectedFailure

from ..utils import TranspileTestCase


class CalendarModuleTests(TranspileTestCase):

	@expectedFailure
	def test_leapdays(self):
	        self.assertCodeExecution("""
	        	num = calendar.leapdays(2015,2018)
	        	print(num)
	        	""")