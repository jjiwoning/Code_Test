from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:

        def dfs(x, y, count):
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 0:
                return count
            grid[x][y] = 0

            count += 1
            count = dfs(x, y + 1, count)
            count = dfs(x, y - 1, count)
            count = dfs(x + 1, y, count)
            count = dfs(x - 1, y, count)
            return count

        cnt = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    cnt = max(cnt, dfs(i, j, 0))
        return cnt