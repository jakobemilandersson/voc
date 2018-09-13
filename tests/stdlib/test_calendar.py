from .. utils import TranspileTestCase

from unittest import expectedFailure

class CalendarModuleTests(TranspileTestCase):

	#@expectedFailure
	def test_leapdays(self):
	        self.assertCodeExecution("""
	        	import calendar
	        	print(calendar.leapdays(2015,2018))
	        	""")
	#@expectedFailure
	def test_leapdays_double(self):
	        self.assertCodeExecution("""
	        	import calendar
	        	print(calendar.leapdays(2015.4,2018))
	        	""")
	#@expectedFailure
	def test_leapdays_descending(self):
	        self.assertCodeExecution("""
	        	import calendar
	        	print(calendar.leapdays(2018,2015))
	        	""")