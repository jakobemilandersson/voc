from .. utils import TranspileTestCase

from unittest import expectedFailure

class CalendarModuleTests(TranspileTestCase):

	#@expectedFailure
	def test_leapdays(self):
	        self.assertCodeExecution("""
	        	import calendar
	        	print(calendar.leapdays(2015,2018))
	        	""")