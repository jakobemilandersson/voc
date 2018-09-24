from unittest import expectedFailure

from ..utils import TranspileTestCase


class DatetimeModuleTests(TranspileTestCase):

    #######################################################
    # __file__
    @expectedFailure
    def test___file__(self):
        self.assertCodeExecution("""
            import datetime
            print(datetime.__file__)
            """)

    # TODO: Check collections' tests for more tests like this

class DateTimeTests(TranspileTestCase):

    def test___new__(self):
        self.assertCodeExecution("""
            from datetime import datetime
            dt = datetime(2001,1,1)
            """)
